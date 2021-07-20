package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static Map<String,String> code2MsgMap = new HashMap<>();

    public static final String SUCCESS_CODE = "000";
    public static final String SUCCESS_MSG = "成功";

    public static final String FAILED_CODE = "999";
    public static final String FAILED_MSG = "系统原因异常，请稍后再试！";

    public static final String DATA_NOT_EXISTES = "501";
    public static final String DATA_NOT_EXISTES_MSG = "数据不存在！";

    public static final String PASSWORD_ERROR = "502";
    public static final String PASSWORD_ERROR_MSG = "密码不正确，请重新输入！";

   static {
       code2MsgMap.put(SUCCESS_CODE,SUCCESS_MSG);
       code2MsgMap.put(FAILED_CODE,FAILED_MSG);
    }

    public static ResponseInfo success(Object object){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setRtnCode(SUCCESS_CODE);
        responseInfo.setRtnMsg(SUCCESS_MSG);
        responseInfo.setData(object);
        return responseInfo;
    }

    public static ResponseInfo error(Object object){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setRtnCode(FAILED_CODE);
        responseInfo.setRtnMsg(FAILED_MSG);
        responseInfo.setData(object);
        return responseInfo;
    }

    public static ResponseInfo error(String rtnCode,String rtnMsg, Object object){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setRtnCode(rtnCode);
        responseInfo.setRtnMsg(rtnMsg);
        responseInfo.setData(object);
        return responseInfo;
    }

    public static String getMsgByCode(String rtnCode) {
        return code2MsgMap.get(rtnCode);
    }
}
