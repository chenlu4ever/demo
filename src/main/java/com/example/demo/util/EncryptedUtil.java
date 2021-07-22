package com.example.demo.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * @author 10450
 * @description MD5+salt
 * @date 2021/7/15 16:37
 */
public class EncryptedUtil {

    /**
     * 生成含有随机盐的密码
     */
    public static String generate(String password,String randomSalt) {
        password = md5Hex(password + randomSalt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = randomSalt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 生成随机盐
     */
    public static String getRandomSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            byte[] bs = md5.digest(src.getBytes());
//            return new String(new Hex().encode(bs));
            return DigestUtils.md5DigestAsHex(src.getBytes());
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String psw = "你好啊@";
        String encode =  generate(psw,getRandomSalt());
        System.out.println("encode = " +encode);
        System.out.println(verify(psw,encode));
//        System.out.println(verify(psw,"068194213561c39219e3e455549a5a32665ec4c41bd24f01"));
    }
}
