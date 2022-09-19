package com.example.demo.designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 10450
 * @description 可以防止反射攻击的单例模式
 * @date 2022/9/15 15:03
 */
public class InnerClassReflexSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //单例保护防止多利情况下：
        Constructor<InnerClassProtectSingleton> declaredConstructor = InnerClassProtectSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassProtectSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassProtectSingleton instance = InnerClassProtectSingleton.getInstance();
        System.out.println(innerClassSingleton);
        System.out.println(instance);
    }
}

/**
 * 防止多例
 */
class InnerClassProtectSingleton {
    private static class InnerClassSingletonHolder {
        private static InnerClassProtectSingleton instance = new InnerClassProtectSingleton();
    }

    private InnerClassProtectSingleton() {
        //添加校验，抛异常
        if (InnerClassSingletonHolder.instance != null) {
            throw new RuntimeException("单例模式，不运行重复创建");
        }
    }

    public static InnerClassProtectSingleton getInstance() {
        return InnerClassProtectSingleton.InnerClassSingletonHolder.instance;
    }
}