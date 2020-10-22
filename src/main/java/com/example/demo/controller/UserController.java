package com.example.demo.controller;

import model.UserModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("/user/login.html");
        return modelAndView;
    }

    @PostMapping(value ="/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid UserModel userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String userName = userVo.getUserName();
        String password = userVo.getPassword();

        if(!"admin".equals(userName)){
            modelAndView.addObject("error","无此用户！");
            modelAndView.setViewName("/user/login.html");
            return modelAndView;
        }
        if(!"123456".equals(password)){
            modelAndView.addObject("error","密码错误！");
            modelAndView.setViewName("/user/login.html");
            return modelAndView;
        }
        modelAndView.addObject("userName",userName);
        modelAndView.setViewName("/user/test.html");
        return modelAndView;
    }
}


