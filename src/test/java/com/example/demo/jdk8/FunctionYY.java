package com.example.demo.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 10450
 * @description 方法引用  ::
 * @date 2021/10/27 10:51
 */
public class FunctionYY {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("aa");
        list.add("bb");
        //静态方法调用
        list.forEach(System.out::println);

        List<Student> users = new ArrayList<Student>();
        users.add(new Student(20, "张三"));
        users.add(new Student(22, "李四"));
        users.add(new Student(10, "王五"));
        users.forEach((Student user) -> System.out.println(user.getAge()));
    }
}
