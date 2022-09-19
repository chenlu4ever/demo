package com.example.demo.designPattern.singleton;

/**
 * @author 10450
 * @description 单模式
 * @date 2021/11/29 16:15
 */
public class MySingleton {
    private volatile static MySingleton instance=  null;

    private MySingleton(){
    }

    public static MySingleton getInstance(){
        if(instance==null){
            synchronized (MySingleton.class) {
                if(instance==null)
                    instance = new MySingleton();
            }
        }
        return instance;
    }
}
