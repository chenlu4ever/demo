package com.example.demo.designPattern.singleton;

import java.lang.reflect.Constructor;

/**
 * @author 10450
 * @description 懒汉模式
 * 并发情况下，有可能
 * @date 2022/9/15 13:58
 */
public class LazySingletonTest {
    public static void main(String[] args){
        new Thread(()->{
            LazySingleton intance = LazySingleton.getInstance();
            System.out.println(intance);
        }).start();

        new Thread(()->{
            LazySingleton intance = LazySingleton.getInstance();
            System.out.println(intance);
        }).start();

        new Thread(()->{
            LazySafeSingleton intance = LazySafeSingleton.getInstance();
            System.out.println(intance);
        }).start();

        new Thread(()->{
            LazySafeSingleton intance = LazySafeSingleton.getInstance();
            System.out.println(intance);
        }).start();

        new Thread(()->{
            LazyVolatileSingleton intance = LazyVolatileSingleton.getInstance();
            System.out.println(intance);
        }).start();

        new Thread(()->{
            LazyVolatileSingleton intance = LazyVolatileSingleton.getInstance();
            System.out.println(intance);
        }).start();
    }
}

/**
 * 多线程不安全
 */
class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if(instance==null){
            try{
                Thread.sleep(5000);
                instance =  new LazySingleton();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
/**
 * 多线程安全,但是指令重排有问题
 */
class LazySafeSingleton{
    private static LazySafeSingleton instance;
    private LazySafeSingleton(){
    }
    public static LazySafeSingleton getInstance(){
        if(instance==null){
            synchronized (LazySafeSingleton.class){
                if(instance==null){
                    try{
                        Thread.sleep(5000);
                        instance =  new LazySafeSingleton();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}

/**
 * 防止指令重排
 */
class LazyVolatileSingleton{
    private volatile static LazyVolatileSingleton instance;
    private LazyVolatileSingleton(){
    }
    public static LazyVolatileSingleton getInstance(){
        if(instance==null){
            synchronized (LazyVolatileSingleton.class){
                if(instance==null){
                    try{
                        Thread.sleep(5000);
                        instance =  new LazyVolatileSingleton();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}



