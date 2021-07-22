package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Exception.DemoRuntimeException;
import com.example.demo.dto.InviteInfoDto;
import com.example.demo.service.InviteService;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invite")
@Api(tags="会议邀请")
public class InviteController {
    public  static Logger logger = LoggerFactory.getLogger(InviteController.class);
    @Autowired
    InviteService inviteService;

    @RequestMapping(value = "/queryInviteDetail" , method = RequestMethod.POST)
    @ApiOperation(value = "查询会议邀约" , notes = "入参示例：{}")
    public ResponseInfo<InviteInfoDto> queryInviteDetai(@RequestBody Map<String,String> requestMap, HttpServletRequest request){
        logger.info("查询会议邀约 queryInviteDetai 入参:"+ JSONObject.toJSONString(requestMap));
        ResponseInfo<InviteInfoDto> responseInfo = new ResponseInfo<>();
        try{
            InviteInfoDto inviteInfoDto = inviteService.queryInviteDetail(requestMap);
            return ResponseUtil.success(inviteInfoDto);
        }catch(DemoRuntimeException e){
            logger.error("查询会议邀约 queryInviteDetai error",e);
            return ResponseUtil.error(e.getErrorCode(),e.getMessage());
        }catch(Exception e){
            logger.error("查询会议邀约 queryInviteDetai error",e);
            return ResponseUtil.error();

        }
    }
}
