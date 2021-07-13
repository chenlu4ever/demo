package com.example.demo.controller;

import com.example.demo.model.TblUserInfo;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("/user/login.html");
        return modelAndView;
    }
}


