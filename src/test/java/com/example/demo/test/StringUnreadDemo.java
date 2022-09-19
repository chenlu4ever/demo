package com.example.demo.test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * String虽然不可读，但指的是地址不可读。
 * 数组内容还是可以变的
 */
public class StringUnreadDemo {
    public static void main(String[] args) {
        //指向常量池，内存地址一致
        String s1 = "ABC";
        System.out.println("s1 : " + System.identityHashCode(s1)); // 1288141870
        String s2 = "ABC";
        System.out.println("s2 : " + System.identityHashCode(s2)); // 1288141870
        String s3 = new String("ABC");
        System.out.println("s3 : " + System.identityHashCode(s3)); // 2054881392

        String s4 = s1;
        System.out.println("s4 : " + System.identityHashCode(s4)); // 1288141870

        s1 = "BCD";
        System.out.println("s1 : " + System.identityHashCode(s1)); // 966808741
        System.out.println("s2 : " + System.identityHashCode(s2)); // 1288141870
        System.out.println("s4 : " + System.identityHashCode(s4)); // 1288141870

        System.out.println();


        String str = "ABC";
        System.out.println("str =" +str +" : "+ System.identityHashCode(str)); // str =ABC : 1288141870
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(str);
            value[0] = 'M';
            System.out.println("str =" +str +" : " + System.identityHashCode(str)); //str =MBC : 1288141870
            System.out.println("s2 =" +s2+" : " + System.identityHashCode(s2)); // s2 =MBC : 1288141870
            System.out.println("s4 =" +s4+" : " + System.identityHashCode(s4)); // s4 =MBC : 1288141870
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
