package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.Map;

/**
 * @author 10450
 * @description TODO
 * @date 2021/7/13 13:39
 */
public class MyBeanUtils {
    public static Object mapTransObject(Map map, Class<?> clazz){
        if (map == null) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }
}
