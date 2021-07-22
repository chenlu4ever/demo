package com.example.demo.controller;

import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 10450
 * @description TODO
 * @date 2021/7/22 11:46
 */
@RestController
public class ErrorController {
    public  static Logger logger = LoggerFactory.getLogger(ErrorController.class);
    /**
     * 重新抛出异常
     */
    @RequestMapping("/error/exthrow")
    public ResponseInfo rethrow(HttpServletRequest request) {
        logger.info ("######################",(Exception) request.getAttribute("filter.error"));
        return ResponseUtil.error();
    }
}
