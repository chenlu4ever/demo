package com.example.demo.jdk8;

import java.util.*;

/**
 * @author 10450
 * @description lambda表达式的语法：
 *
 * 　　　　 (parameters) -> expression 或
 *
 * 　　　　 (parameters) -> { statements; }，
 *
 * 　　　　即() -> {}，等同于 new Interface(){}
 * @date 2021/12/15 11:11
 */
public class LambdaTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>(){{
            put(1,"A");
            put(2,"BB");
            put(3,"CC");
        }};
       map.forEach((k,v)-> System.out.println(String.valueOf(k)+":"+v));
       map.forEach((k,v)->{
           System.out.println(++k +":"+v);
       });

       List list = new ArrayList(){{
           add("good");
           add("mornig");
       }};

       list.forEach(System.out::println);
       list.forEach((t)-> System.out.println(t));
       list.forEach((t)->{
           System.out.println("t = " +t);
       });
    }
}
