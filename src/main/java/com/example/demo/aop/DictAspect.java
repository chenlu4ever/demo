package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.TblDictService;
import com.example.demo.util.ObjConvertUtils;
import com.example.demo.util.PageInfo;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.SensitiveInfoUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/4 10:14
 */
@Aspect
@Component
public class DictAspect {
    public  static Logger logger = LoggerFactory.getLogger(DictAspect.class);

    //这是操作数据字典那张表的 service
    @Autowired
    private TblDictService tblDictService;

    //翻译后拼接的内容
    private static String DICT_TEXT_SUFFIX = "_dictText";

    // 定义切点Pointcut 拦截所有对服务器的请求
    @Pointcut("execution( * com.example.demo.controller.*.*(..))")
    public void excudeService() {
    }

    /**
     * 这是触发 excudeService 的时候会执行的
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        //防止不是http请求的方法，例如：scheduled
        if (ra == null || sra == null) {
            return pjp.proceed();
        }

        HttpServletRequest request = sra.getRequest();
        logger.info(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName()+" params:"+JSON.toJSONString(pjp.getArgs()));

        //这是定义开始事件
        long time1 = System.currentTimeMillis();
        //这是方法并获取返回结果
        Object response = pjp.proceed();
        //这是获取到 结束时间
        long time2 = System.currentTimeMillis();
        logger.debug("获取JSON数据 耗时：" + (time2 - time1) + "ms");
        //解析开始时间
        long start = System.currentTimeMillis();
        //开始解析（翻译字段内部的值凡是打了 @Dict 这玩意的都会被翻译）
        this.parseDictText(response);
        //解析结束时间
        long end = System.currentTimeMillis();
        logger.debug("处理返回数据  耗时" + (end - start) + "ms");

        logger.info(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName()+" return:{}", response != null ? JSON.toJSONString(response) : "");
        return response;
    }

    /**
     * 本方法针对返回对象为Result 的IPage的分页列表数据进行动态字典注入
     * 字典注入实现 通过对实体类添加注解@dict 来标识需要的字典内容,字典分为单字典code即可 ，table字典 code table text配合使用与原来jeecg的用法相同
     * 示例为SysUser   字段为sex 添加了注解@Dict(dicCode = "sex") 会在字典服务立马查出来对应的text 然后在请求list的时候将这个字典text，已字段名称加_dictText形式返回到前端
     * 例输入当前返回值的就会多出一个sex_dictText字段
     * {
     * sex:1,
     * sex_dictText:"男"
     * }
     * 前端直接取值sext_dictText在table里面无需再进行前端的字典转换了
     * customRender:function (text) {
     * if(text==1){
     * return "男";
     * }else if(text==2){
     * return "女";
     * }else{
     * return text;
     * }
     * }
     * 目前vue是这么进行字典渲染到table上的多了就很麻烦了 这个直接在服务端渲染完成前端可以直接用
     *
     * @param result
     */
    private void parseDictText(Object result) {
        if (result instanceof ResponseInfo) {
            ResponseInfo responseInfo = (ResponseInfo) result;
            if(result!=null && ((ResponseInfo) result).getData()!=null){
               Object obj = ((ResponseInfo) result).getData();
               if(obj instanceof PageInfo){
                   List<JSONObject> items = new ArrayList<>();
                   PageInfo pageInfo = (PageInfo) obj;
                   //循环查找出来的数据
                   for (Object record : pageInfo.getRows()) {
                       items.add(transDicFunc(record));
                   }
                   pageInfo.setRows(items);
                   responseInfo.setData(pageInfo);
               }else if(obj instanceof List){
                   List list = (List) obj;
                   List returnList = new ArrayList();
                   for (Object record : list ) {
                       returnList.add(transDicFunc(record));
                   }
                   responseInfo.setData(returnList);
               }else if(obj instanceof String){
                   return;
               }else{
                   responseInfo.setData(transDicFunc(obj));
               }
            }
        }
    }

    private JSONObject transDicFunc(Object record) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            //解决@JsonFormat注解解析不了的问题详见SysAnnouncement类的@JsonFormat
            json = mapper.writeValueAsString(record);
        } catch (JsonProcessingException e) {
            logger.error("json解析失败" + e.getMessage(), e);
        }
        JSONObject item = JSONObject.parseObject(json);

        //update-begin--Author:scott -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
        //for (Field field : record.getClass().getDeclaredFields()) {
        for (Field field : ObjConvertUtils.getAllFields(record)) {
            //update-end--Author:scott  -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
            if (field.getAnnotation(Dict.class) != null) {
                String code = field.getAnnotation(Dict.class).dictDataSource();
                String text = field.getAnnotation(Dict.class).dictText();
                //获取当前带翻译的值
                String key = item.get(field.getName())==null?null:String.valueOf(item.get(field.getName()));
                if(!StringUtils.isEmpty(key)){
                    //翻译字典值对应的txt
                    String textValue = translateDictValue(code, key);
                    //  CommonConstant.DICT_TEXT_SUFFIX的值为，是默认值：
                    // public static final String DICT_TEXT_SUFFIX = "_dictText";
                    logger.debug(" 字典Val : " + textValue);
                    logger.debug(" __翻译字典字段__ " + field.getName() + DICT_TEXT_SUFFIX + "： " + textValue);
                    //如果给了文本名
                    if (!StringUtils.isEmpty(text)) {
                        item.put(text, textValue);
                    } else {
                        //走默认策略
                        item.put(field.getName() + DICT_TEXT_SUFFIX, textValue);
                    }
                }
            }

            if (field.getAnnotation(SensitiveLabel.class) != null) {
                SensitiveTypeEnum typeEnum = field.getAnnotation(SensitiveLabel.class).type();
                String value = item.get(field.getName())==null?null:String.valueOf(item.get(field.getName()));
                String value_n = "";
                if(!StringUtils.isEmpty(value) && SensitiveTypeEnum.MOBILE_PHONE.equals(typeEnum)){
                    value_n = SensitiveInfoUtils.mobilePhone(value);
                    item.put(field.getName(),value_n);
                }
            }
            //date类型默认转换string格式化日期
            if (field.getType().getName().equals("java.util.Date") && field.getAnnotation(JsonFormat.class) == null && item.get(field.getName()) != null) {
                SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
            }
        }
        return item;
    }


    /**
     * 翻译字典文本
     *
     * @param code
     * @param key
     * @return
     */
    private String translateDictValue(String code, String key) {
        //如果key为空直接返回就好了
        if (ObjConvertUtils.isEmpty(key)) {
            return null;
        }
        StringBuffer textValue = new StringBuffer();
        //分割 key 值
//        System.out.println(code+":::::"+key);
        String[] keys = key.split(",");
        //循环 keys 中的所有值
        for (String k : keys) {
            String tmpValue = null;
            logger.debug(" 字典 key : " + k);
            if (k.trim().length() == 0) {
                continue; //跳过循环
            }
            Map<String,String> dataDcit = tblDictService.queryDataDict();
            tmpValue = dataDcit.get(code+"_"+key);

            if (tmpValue != null) {
                if (!"".equals(textValue.toString())) {
                    textValue.append(",");
                }
                textValue.append(tmpValue);
            }
        }
        //返回翻译的值
        return textValue.toString();
    }

}