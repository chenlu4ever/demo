package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dto.UserDTO;

public class Test {
    public static int a = 10;

    public static void main(String[] args) {
        UserDTO model = new UserDTO();
        System.out.println(JSONObject.toJSONString(model));
    }


}

