package com.example.demo.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/22 11:28
 */
public class SerialMain {
    public static void main(String[] args) throws IOException {
        SerialVO person = new SerialVO(1234, "wang");
        System.out.println("Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
