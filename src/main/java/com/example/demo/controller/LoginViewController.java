//package com.example.demo.controller;
//
//import com.example.demo.Exception.DemoRuntimeException;
//import com.example.demo.configuration.WebUtil;
//import com.example.demo.dto.UserSessionDTO;
//import com.example.demo.model.TblUserInfo;
//import com.example.demo.service.UserInfoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
//@Controller
//@Api(tags = "登录管理")
//public class LoginViewController {
//    private static  final Logger logger = LoggerFactory.getLogger(LoginViewController.class);
//
//    @Autowired
//    UserInfoService userInfoService;
//
//    @GetMapping("/index")
//    public ModelAndView index(ModelAndView modelAndView){
//        modelAndView.setViewName("/user/login.html");
//        return modelAndView;
//    }
//
//    @PostMapping(value ="/loginSimple")
//    @ApiOperation(value = "简单登录", notes = "入参实例：{\"loginId\":\"testId\",\"password\":\"aaaaa888@\"}")
//    public ModelAndView login(ModelAndView modelAndView,@RequestParam Map<String,Object> requestMap){
//        try{
//            TblUserInfo tblUserInfo = userInfoService.checkUserLogin(requestMap);
//            UserSessionDTO userSessionDTO = new UserSessionDTO();
//            BeanUtils.copyProperties(tblUserInfo,userSessionDTO);
//            WebUtil.setUserSession(userSessionDTO);
//            modelAndView.addObject("user",tblUserInfo);
//            modelAndView.setViewName("/user/test.html");
//        }catch (DemoRuntimeException e){
//            logger.info("loginSimple error:" ,e);
//            modelAndView.addObject("error",e.getMessage());
//            modelAndView.setViewName("/user/login.html");
//
//        }catch (Exception e){
//            logger.info("loginSimple error:" ,e);
//            modelAndView.addObject("error","登录失败！！");
//            modelAndView.setViewName("/user/login.html");
//        }
//        return modelAndView;
//    }
//}
//
//
