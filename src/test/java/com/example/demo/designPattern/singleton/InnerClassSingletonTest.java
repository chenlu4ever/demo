package com.example.demo.designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 10450
 * @description 静态内部类
 * 可以防止通过反射，实现多利
 * @date 2022/9/15 14:28
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        new Thread(()->{
            System.out.println(InnerClassSingleton.getInstance());
        }).start();

        new Thread(()->{
            System.out.println(InnerClassSingleton.getInstance());
        }).start();
        
        //利用反射方式创建类对象打破单例模式，实现多利
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton);
        System.out.println(instance);
    }
}

class InnerClassSingleton{
    private static class InnerClassSingletonHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton(){
    }
    public static InnerClassSingleton getInstance(){
        try {
            System.out.println(1);
            Thread.sleep(8000);
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return InnerClassSingletonHolder.instance;
    }
}
