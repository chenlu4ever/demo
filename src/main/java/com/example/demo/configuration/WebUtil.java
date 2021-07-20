package com.example.demo.configuration;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 10450
 * @description session信息
 * @date 2021/7/19 17:14
 */
public final class WebUtil {
    private static Logger logger =  LoggerFactory.getLogger(WebUtil.class);
    private static final String USER_KEY = "user";

    public static void setUserSession(UserDTO userVo) {
        setSession(USER_KEY, JSONObject.toJSONString(userVo));
    }

    private static void setSession(String key, String obj) {
        HttpSession httpSession = getHttpServletRequest().getSession(true);
        httpSession.setMaxInactiveInterval(30*60);
        httpSession.setAttribute(key,obj);
    }

    public static HttpServletRequest getHttpServletRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getHttpServletResponse(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

}
