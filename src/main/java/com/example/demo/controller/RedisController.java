package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //添加
    @GetMapping(value="/redisAdd")
    public void saveRedis(){
        stringRedisTemplate.opsForValue().set("a","test");
    }

    //获取
    @RequestMapping(value = "/redisGet" , method = RequestMethod.POST)
    @ApiOperation(value = "获取Redis" , notes = "入参示例：{}")
    public String getRedis(@RequestParam String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
