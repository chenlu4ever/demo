package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/14 11:14
 */
public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        return "1234";
    }

    public static void main(String[] args) {
        FutureTask futureTask1 = new FutureTask(new CallableTest());
        Thread thread1 = new Thread(futureTask1);
        thread1.start();
        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
