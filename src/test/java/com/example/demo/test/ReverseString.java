package com.example.demo.test;

/**
 * @author 10450
 * @description 递归反转字符
 * @date 2021/3/26 16:01
 */
public class ReverseString {
    private static  String TEST_STR = "ABCDEF";
    private static int STR_LENGTH = 0;
    public static void main(String[] args) {
        System.out.println(TEST_STR);
        STR_LENGTH = TEST_STR.length()-1;
        PintChar(STR_LENGTH);
    }

    public static void PintChar(int idext){
        if(idext>=0){
            System.out.println(TEST_STR.charAt(idext));
            PintChar(--idext);
        }
    }
}
