//package com.example.demo.configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @author 10450
// * @description 安全
// * @date 2021/3/22 17:05
// */
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // web.ignoring是直接绕开spring security的所有filter，直接跳过验证
//        web.ignoring().antMatchers(
//                "/swagger-ui.html",
//                "/v2/api-docs", // swagger api json
//                "/swagger-resources/configuration/ui", // 用来获取支持的动作
//                "/swagger-resources", // 用来获取api-docs的URI
//                "/swagger-resources/configuration/security", // 安全选项
//                "/swagger-resources/**",
//                //补充路径，近期在搭建swagger接口文档时，通过浏览器控制台发现该/webjars路径下的文件被拦截，故加上此过滤条件即可。
//                "/webjars/**"
//        );
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET).permitAll()
//                .antMatchers(HttpMethod.POST).permitAll()
//                .antMatchers("/v1/**").permitAll() //swagger
//        ;
//
//        http.formLogin();
//
////        http.logout().logoutUrl("/api/session/logout")
////                // 登出前调用，可用于日志
////                .addLogoutHandler(customLogoutHandler)
////                // 登出后调用，用户信息已不存在
////                .logoutSuccessHandler(customLogoutHandler);
//
//        http.exceptionHandling()
//                // 已登入用户的权限错误
//                .accessDeniedHandler(customAccessDeniedHandler)
//                // 未登入用户的权限错误
//                .authenticationEntryPoint(customAccessDeniedHandler);
//
//        http.csrf().disable();
//
////        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//
//
//
//        //XSS 攻击
////        http.headers().frameOptions().disable().contentSecurityPolicy("script-src 'self' https://trustedscripts.example.com; object-src https://trustedplugins.example.com; report-uri /csp-report-endpoint/");
////
////        //csrf 跨站点请求伪造(Cross-Site Request Forgery )  CSRF或者XSRF
////        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//
////        //主要是看UrlMatchVoter,所有的权限检查都在UrlMatchVoter
////        http
////                .cors()
////                .and()
////                .csrf().disable()
////                .authorizeRequests()
////                // http.permitAll不会绕开springsecurity验证，相当于是允许该路径通过 swagger可以不用登录
////                .antMatchers("/v1/**").permitAll();
//////                .accessDecisionManager(accessDecisionManager())
//
//    }
//
////    @Bean
////    public AccessDecisionManager accessDecisionManager() {
//
//}
