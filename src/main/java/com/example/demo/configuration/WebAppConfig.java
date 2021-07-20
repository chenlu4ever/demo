package com.example.demo.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 10450
 * @description TODO
 * @date 2021/7/20 10:47
 */
public class WebAppConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/v1/**/**");
//    }

    /**
     * 解决security下跨域失效问题,
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                // 放行哪些原始域
                .allowedOrigins("*")
                // 是否发送cookie
                .allowCredentials(true)
                // 放行哪些请求:"GET", "POST", "OPTIONS", "DELETE", "PUT"
                .allowedMethods("GET", "POST")
                // 放行哪些header
                .allowedHeaders("*")
                // 暴露哪些头部信息(因为跨域访问默认不能获取全部header
                .exposedHeaders("Header1", "Header2");

    }
}
