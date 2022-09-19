package com.example.demo.serializable;

import java.io.*;

/**
 * @author 10450
 * @description 反序列
 * @date 2021/12/22 11:28
 */
public class DeSerialMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialVO person;

        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (SerialVO) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
