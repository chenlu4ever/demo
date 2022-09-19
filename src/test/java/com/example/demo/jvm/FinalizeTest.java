package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10450
 * @description 垃圾回收
 * @date 2022/8/25 15:52
 */
public class FinalizeTest {

    public static void main(String[] args) {
        //局部变量
        List<Object> list = new ArrayList<>();
        int i=0;
        int j=0;
        while (true){
            list.add(new User("强引用"+(i++))); //有GC Root引用
            new User("无引用"+(j++)); //没有GC Root引用 ---会被回收
        }
    }

    public static class User{
        private String name;
        public User(String name){
            this.name=name;
        }

        protected void finalize() throws Throwable {
            System.out.println(name+"需要关闭资源");
        }
    }


}
