package com.example.demo.configuration;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10450
 * @description spring配置
 * @date 2021/7/20 10:47
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List userExcludes =  new ArrayList<>();
        userExcludes.add("/loginSimple");
        //swagger
        userExcludes.add("/error");
        userExcludes.add("/webjars/**");
        userExcludes.add("/swagger-resources/**");

        userExcludes.add("/**/*.html"); //html静态资源
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(userExcludes);
    }

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

    /**
     * 配置静态访问资源
     * addResoureHandler：指的是对外暴露的访问路径
     * addResourceLocations：指的是内部文件放置的目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
