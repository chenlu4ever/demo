package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value ="/sayHi",method = RequestMethod.GET)
    public String sayHi(){
        return "你好！";
    }
}
