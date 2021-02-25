package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.UserModel;

public class Test {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        System.out.println(JSONObject.toJSONString(model));
    }


}

