package com.example.demo.util;

/**
 * @author 10450
 * @description 自定义StringUtil
 * @date 2021/7/20 16:18
 */
public class DemoStringUtil {
    public static String safeToString(Object object) {
        try{
            return (String) object;
        }catch (Exception e){
            return null;
        }
    }
}
