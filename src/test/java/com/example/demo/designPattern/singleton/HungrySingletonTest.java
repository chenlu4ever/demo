package com.example.demo.designPattern.singleton;

/**
 * @author 10450
 * @description 恶汉模式
 * 类加载的时候完成初始化
 * 可以防止通过反射，实现多利
 * @date 2022/9/15 14:23
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
    }
}

class HungrySingleton{
    private static HungrySingleton  instance = new HungrySingleton();
    private HungrySingleton(){
    }
    public static HungrySingleton getInstance(){
        return instance;
    }
}