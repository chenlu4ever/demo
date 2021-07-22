//package com.example.demo.filter;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
///**
// * @author 10450
// * @description 处理filter异常
// * @date 2021/7/22 10:50
// */
//@Component
//public class ExceptionFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            // 异常捕获，发送到error controller
//            request.setAttribute("filter.error", e);
//            //将异常分发到/error/exthrow控制器
//            request.getRequestDispatcher("/error/exthrow").forward(request, response);
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
