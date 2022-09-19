package com.example.demo.vo;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/24 11:30
 */
public class UserTestVO {
    int uid;
    String userName;
    int age;

    public UserTestVO(int uid, String userName, int age) {
        this.uid=uid;
        this.userName=userName;
        this.age=age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
