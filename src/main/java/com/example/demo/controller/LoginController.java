package com.example.demo.controller;

import com.example.demo.Exception.DemoRuntimeException;
import com.example.demo.configuration.WebUtil;
import com.example.demo.dto.UserSessionDTO;
import com.example.demo.model.TblUserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import com.sun.deploy.nativesandbox.comm.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@Api(tags = "登录管理")
public class LoginController {
    private static  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value ="/loginSimple")
    @ApiOperation(value = "简单登录", notes = "入参实例：{\"loginId\":\"testId\",\"password\":\"aaaaa888@\"}")
    public ResponseInfo login(@RequestBody Map<String,Object> requestMap){
        try{
            TblUserInfo tblUserInfo = userInfoService.checkUserLogin(requestMap);
            UserSessionDTO userSessionDTO = new UserSessionDTO();
            BeanUtils.copyProperties(tblUserInfo,userSessionDTO);
            WebUtil.setUserSession(userSessionDTO);
            return ResponseUtil.success(userSessionDTO);
        }catch (DemoRuntimeException e){
            logger.info("loginSimple error:" ,e);
            return ResponseUtil.error(e.getErrorCode(),e.getMessage());
        }catch (Exception e){
            logger.info("loginSimple error:" ,e);
            return ResponseUtil.error();
        }
    }
}


