package com.example.demo.deadLock;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 10450
 * @description 新增信号量解决死锁
 * @date 2021/12/18 21:41
 */
public class DeadLockTest {
    public static final Semaphore a1 = new Semaphore(1);
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {
        DLThread1 threadA = new DLThread1();
        DLThread2 threadB = new DLThread2();
        threadA.start();
        threadB.start();
    }

    static class DLThread1 extends Thread {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now()+ " DLThread1 start!");
            try {
                if(a1.tryAcquire(3, TimeUnit.SECONDS)) {
                    System.out.println(LocalDateTime.now() + " DLThread1 拿到 a1");
                    Thread.sleep(3000);
                    if(a2.tryAcquire(3, TimeUnit.SECONDS)){
                        System.out.println(LocalDateTime.now()+ " DLThread1 拿到 a2");
                    }else{
                        System.out.println(LocalDateTime.now()+ " DLThread1 放弃 a2");
                    }
                }else{
                    System.out.println(LocalDateTime.now()+ " DLThread1 放弃 a1");
                }
                a1.release();
                a2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now()+ " DLThread1 end!");
        }
    }

    static class DLThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now()+ " DLThread2 start!");
            try {
                if(a2.tryAcquire(3, TimeUnit.SECONDS)) {
                    System.out.println(LocalDateTime.now()+ " DLThread2 拿到 a2");
                    Thread.sleep(3000);
                    if(a2.tryAcquire(3, TimeUnit.SECONDS)) {
                        System.out.println(LocalDateTime.now()+ " DLThread2 拿到 a1");
                    }else{
                        System.out.println(LocalDateTime.now()+ " DLThread2 放弃 a1");
                    }
                }else{
                    System.out.println(LocalDateTime.now()+ " DLThread1 放弃 a2");
                }
                a1.release();
                a2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now()+ " DLThread2 end!");
        }
    }
}
