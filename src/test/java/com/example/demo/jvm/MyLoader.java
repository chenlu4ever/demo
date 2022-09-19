package com.example.demo.jvm;

/**
 * @author 10450
 * @description 类加载调用关系
 * @date 2022/8/23 14:27
 */
public class MyLoader{
    static {
        System.out.println("MyLoader类静态");
    }
    public static void main(String[] args) {
        MyNULL myNULL = null;
        MyChild child = new MyChild("你好");
    }
}

class MyChild extends MyParent {
    static {
        System.out.println("MyChild类静态");
    }
    MyChild(){
        System.out.println("MyChild默认构造方法");
    }
    MyChild(String name){
        System.out.println("MyChild带参数构造方法");
    }
}

class MyParent {
    static {
        System.out.println("MyParent类静态");
    }
    MyParent(){
        System.out.println("MyParent默认构造方法");
    }
}

class MyNULL{
    static {
        System.out.println("MyNULL类静态");
    }
    MyNULL(){
        System.out.println("MyNULL默认构造方法");
    }
}
