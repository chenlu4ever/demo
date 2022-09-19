package com.example.demo.util;

import com.example.demo.controller.LoginController;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 10450
 * @description 分布式锁工具类
 * @date 2022/9/16 17:12
 */
@Component
public class DistributedRedisLock {
    private static  final Logger log = LoggerFactory.getLogger(DistributedRedisLock.class);

    @Autowired
    private RedissonClient redissonClient;

    // 加锁
    public Boolean lock(String lockName) {
        if (redissonClient == null) {
            log.info("DistributedRedisLock redissonClient is null");
            return false;
        }

        try {
            RLock lock = redissonClient.getLock(lockName);
            // 锁15秒后自动释放，防止死锁
            lock.lock(15, TimeUnit.SECONDS);

            log.info("Thread [{}] DistributedRedisLock lock [{}] success", Thread.currentThread().getName(), lockName);
            // 加锁成功
            return true;
        } catch (Exception e) {
            log.error("DistributedRedisLock lock [{}] Exception:", lockName, e);
            return false;
        }
    }

    // 释放锁
    public Boolean unlock(String lockName) {
        if (redissonClient == null) {
            log.info("DistributedRedisLock redissonClient is null");
            return false;
        }

        try {
            RLock lock = redissonClient.getLock(lockName);
            lock.unlock();
            log.info("Thread [{}] DistributedRedisLock unlock [{}] success", Thread.currentThread().getName(), lockName);
            // 释放锁成功
            return true;
        } catch (Exception e) {
            log.error("DistributedRedisLock unlock [{}] Exception:", lockName, e);
            return false;
        }
    }

}
