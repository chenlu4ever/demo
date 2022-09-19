package com.example.demo.test;

/**
 * @author 10450
 * @description 原子性
 * @date 2021/11/29 15:24
 */
public class AutomaticTest {
    public volatile int i = 0 ;
    public synchronized  void increaseI(){
        i++;
    }
    public static void main(String[] args) throws InterruptedException {
        final AutomaticTest test = new AutomaticTest();
        for (int p=0;p<5;p++) {
            new Thread() {
                public void run() {
                    for (int k = 0; k < 1000; k++) {
                        test.increaseI();
                    }
                }
            }.start();
        }
       Thread.sleep(2000);
        System.out.println(test.i);
        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();
    }

}
