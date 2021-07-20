package com.example.demo.controller;

import com.example.demo.model.TblUserInfo;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.MyBeanUtils;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    private static  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value ="/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户信息", notes = "请求参数： {\"userName\":\"测试用户\",\"password\":\"aaaaa888@\",\"loginId\":\"testId\",\"telephone\":\"186222222222\"}")
    public ResponseInfo addUser(@RequestBody Map<String,Object> requestMap){
        ResponseInfo info = new ResponseInfo();
        TblUserInfo tblUserInfo = (TblUserInfo) MyBeanUtils.mapTransObject(requestMap,TblUserInfo.class);
        userInfoService.addUser(tblUserInfo);
        return ResponseUtil.success(tblUserInfo);
    }

    @RequestMapping(value ="/queryUserList",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户列表", notes = "请求参数： {\"userName\":\"李四\"}")
    public ResponseInfo queryUserList(@RequestBody Map<String,Object> requestMap){
        ResponseInfo info = new ResponseInfo();
        TblUserInfo tblUserInfo = (TblUserInfo) MyBeanUtils.mapTransObject(requestMap,TblUserInfo.class);
        List<TblUserInfo> list = userInfoService.queryUserList(tblUserInfo);
        return ResponseUtil.success(list);
    }

    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        Map map = new HashMap<>();
        map.put("name","张三");
        modelAndView.addObject("user",map);
        modelAndView.setViewName("/user/test.html");
        return modelAndView;
    }

    @PostMapping(value ="/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid UserDTO userVo, BindingResult bindingResult){
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


