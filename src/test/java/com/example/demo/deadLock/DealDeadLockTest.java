package com.example.demo.deadLock;

/**
 * @author 10450
 * @description 死锁
 * 互斥资源、不可抢占、请求和保持、循环等待
 * 线程A开启同步，抢占lock1,并在等待lock2资源  线程B开启懂不抢占lock2 并在等待lock1
 * @date 2021/12/18 21:41
 */
public class DealDeadLockTest {
    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {
        DLThread1 threadA = new DLThread1();
        DLThread2 threadB = new DLThread2();
        threadA.start();
        threadB.start();
    }

    static class DLThread1 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName() + "DLThread1 start!");
            try {
                synchronized (lock1) {
                    System.out.println(this.getName() + "DLThread1 拿到lock1");
                    Thread.sleep(3000);
                    synchronized (lock2) {
                        System.out.println(this.getName() + "DLThread1 拿到lock2");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " DLThread1 end!");
        }
    }

    static class DLThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName() + " DLThread2 start!");
            try {
                synchronized (lock2) {
                    System.out.println(this.getName() + "DLThread2 拿到lock2");
                    Thread.sleep(3000);
                    synchronized (lock1) {
                        System.out.println(this.getName() + "DLThread2 拿到lock1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " DLThread2 end!");
        }
    }
}
