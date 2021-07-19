package com.example.demo.util;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/4 10:22
 */
import com.example.demo.model.TblUserInfo;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjConvertUtils {
    /**
     * 获取类的所有属性，包括父类
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if ("".equals(object)) {
            return (true);
        }
        if ("null".equals(object)) {
            return (true);
        }
        return (false);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Field[] fieds = TblUserInfo.class.getDeclaredFields();
        for (Field field:fieds
        ) {
            sb.append("\""+field.getName()+"\":\""+field.getAnnotation(ApiModelProperty.class).value()+"\",");
        }
        System.out.println(sb.toString());
    }


}