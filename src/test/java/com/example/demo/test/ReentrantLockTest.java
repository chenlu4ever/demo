package com.example.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/14 10:35
 */
public class ReentrantLockTest {
    private static final Lock lock1 = new ReentrantLock();// 默认false 非公平锁
    private static final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            new Thread(()).start();
        }
    }

    private static void test(){

    }
}
