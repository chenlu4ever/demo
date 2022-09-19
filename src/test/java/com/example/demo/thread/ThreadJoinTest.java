package com.example.demo.thread;

import java.time.LocalDateTime;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/14 16:48
 */
public class ThreadJoinTest extends Thread{
    @Override
    public void run() {
        System.out.println( "run start: "+LocalDateTime.now());
        try {
            Thread.sleep(5000); // 等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "run finish: "+LocalDateTime.now());
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+":"+LocalDateTime.now());
        ThreadJoinTest threadJoinTest = new ThreadJoinTest();
        threadJoinTest.start();
        threadJoinTest.join(); //有没有这行结果不一样
        System.out.println( "结束！ "+LocalDateTime.now());

    }
}
