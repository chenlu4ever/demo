package com.example.demo.designPattern.proxy;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/21 13:48
 */
public class SubjectImpl implements Subject {
    @Override
    public String sayHello() {
        System.out.println(" Hello World");
        return "success";
    }
}
