package com.example.demo.controller;

import com.example.demo.configuration.RedissionConfig;
import com.example.demo.model.TblHolding;
import com.example.demo.util.DistributedRedisLock;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;


    private final static  String HOLDING_PRE = "holding_key_";

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

    @RequestMapping(value = "/getProduct" , method = RequestMethod.GET)
    @ApiOperation(value = "获取数据" , notes = "测试读锁")
    public String getProduct(@RequestParam("id") String id){
        String lockkey = "tbl_holding_lockkey_"+id;
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(lockkey);
        RLock rLock = readWriteLock.readLock();
        rLock.lock();
        try{
            System.out.println("获取读锁成："+lockkey);
            if(stringRedisTemplate.hasKey(HOLDING_PRE+id)){
                return stringRedisTemplate.opsForValue().get(HOLDING_PRE+id);
            }else{
                //查询数据库
            }

        }catch(Exception e){
            throw e;
        }finally {
            rLock.unlock();
            System.out.println("获取释放锁成："+lockkey);
        }
        return "";
    }

    @RequestMapping(value = "/updateHolding" , method = RequestMethod.POST)
    @ApiOperation(value = "更新数据" , notes = "测试写锁")
    public String updateHolding(@RequestBody TblHolding tblHolding){
        Long id = tblHolding.getId();
        String lockkey = "tbl_holding_lockkey_"+tblHolding.getId();
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(lockkey);
        RLock rLock = readWriteLock.writeLock();
        rLock.lock();
        try{
            System.out.println("获取读锁成："+lockkey);
            //更新数据库
            return stringRedisTemplate.opsForValue().get(HOLDING_PRE+id);
        }catch(Exception e){

        }finally {
            rLock.unlock();
            System.out.println("获取释放锁成："+lockkey);
        }
        return "";
    }

    @RequestMapping(value = "/sign" , method = RequestMethod.POST)
    @ApiOperation(value = "签到" , notes = "测试布隆过滤器")
    public String sign(@RequestBody TblHolding tblHolding){

        RBloomFilter<Object> bloom_user_2022_01_01 = redissonClient.getBloomFilter("bloom_user_2022_01_01");
        if(bloom_user_2022_01_01.contains("zhangsan")){
           //查询缓存或者数据库
        }else{

        }
        return null;
    }
}
