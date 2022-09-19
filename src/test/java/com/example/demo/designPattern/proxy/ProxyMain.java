package com.example.demo.designPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/21 13:52
 */
public class ProxyMain {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject proxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new ProxyInvocationHandler(subject));

        proxy.sayHello();
    }
}

