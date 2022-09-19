package com.example.demo.thread;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/14 10:59
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest test1 = new ThreadTest();
        test1.setName("test1");
        test1.start();
    }

}
