package com.example.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.configuration.WebUtil;
import com.example.demo.dto.UserSessionDTO;
import com.example.demo.util.ResponseInfo;
import com.example.demo.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 10450
 * @description 登录拦截器
 * @date 2021/7/20 15:40
 */
public class LoginInterceptor implements HandlerInterceptor {
    public static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LoginInterceptor preHandle:"+ request.getRequestURI());
        UserSessionDTO userSessionDTO = WebUtil.getUserSession(request);
        if(userSessionDTO==null){
            returnJson(response);
            return false;
        }
        return true;
    }

    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            ResponseInfo responseInfo = ResponseUtil.error(ResponseUtil.NOT_LOGIN,ResponseUtil.NOT_LOGIN_MSG);
            writer.print(JSONObject.toJSONString(responseInfo));
        } catch (IOException e){
            logger.error("拦截器输出流异常",e);
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

}
