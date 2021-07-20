package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 * @author 10450
 * @description 开启Redis Http Session
 * @date 2021/7/19 16:21
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfiguration {
}
