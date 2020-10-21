package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        final List<String> list = new ArrayList();
        list.add("324234234");
        System.out.println("args = " + list.get(0));
        list.add("444444444444");
        System.out.println("args = " + list.get(1));


        final String aaa = "3432432";
        System.out.println("args = " + aaa);
    }
}
