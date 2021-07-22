//package com.example.demo.filter;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//
//import javax.servlet.Filter;
//
///**
// * @author 10450
// * @description 控制Filter执行顺序
// * @date 2021/7/22 11:05
// */
//public class FilterOrderConfig {
//    @Bean
//    public Filter myExceptionFilter() {
//        return new ExceptionFilter();//自定义的过滤器
//    }
//
//    @Bean
//    public Filter myXssFilter() {
//        return new XssFilter();//自定义的过滤器
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean1() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(myExceptionFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(1);//order的数值越小 则优先级越高
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean2() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(myXssFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(2);
//        return filterRegistrationBean;
//    }
//
//}