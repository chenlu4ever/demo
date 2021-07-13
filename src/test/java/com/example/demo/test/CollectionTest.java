package com.example.demo.test;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/20 15:37
 */
public class CollectionTest {
    static int a = 0;
    static int b= 0;

    public static void main(String[] args) {
        for (int i = 0; i<100; i++){
            new Thread(() -> {
                a++;
                ++b;
            }).start();
        }
        System.out.println(a);
        System.out.println(b);
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//
//        List list = new ArrayList<>();  //List extends Collection<E>

    }
}
