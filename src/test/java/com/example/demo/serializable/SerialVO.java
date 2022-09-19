package com.example.demo.serializable;

import java.io.Serializable;

/**
 * @author 10450
 * @description 序列
 * @date 2021/12/22 11:27
 */
public class SerialVO implements Serializable {
    private static final long serialVersionUID = 123456789L;
    public int id;
    public String name;

    public SerialVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Person: " + id + " " + name;
    }
}
