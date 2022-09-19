package com.example.demo.thread;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/14 11:03
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableTest run1 = new RunnableTest();
        Thread thread1= new Thread(run1);
        thread1.setName("run1");
        thread1.start();
    }
}
