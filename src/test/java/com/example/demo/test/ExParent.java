package com.example.demo.test;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/11 10:54
 */
public class ExParent {
    String name;
    String type;

    public ExParent(){
        System.out.println("ExParent()");
    }
    public ExParent(String name, String type){
        this.name = name;
        this.type = type;
    }
    public static void printBystatic(){
        System.out.println("ExParent.printBystatic()");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
