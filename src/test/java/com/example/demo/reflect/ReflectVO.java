package com.example.demo.reflect;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/21 14:54
 */
public class ReflectVO {
    String name;

    ReflectVO(){
        System.out.println("hi1");
    }

    public void sayHi(String name){
        System.out.println("hi," + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
