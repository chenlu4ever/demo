package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        Map map = new HashMap<>();
        map.put("name","张三");
        modelAndView.addObject("user",map);
        modelAndView.setViewName("/user/test.html");
        return modelAndView;
    }
}
