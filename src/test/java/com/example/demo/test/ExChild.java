package com.example.demo.test;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/11 10:56
 */
public class ExChild extends ExParent {
    public ExChild(){
        System.out.println("ExChild()");
    }
    public ExChild(String name){
        super.name=name;
        System.out.println("ExChild(String name)");
    }
    public ExChild(String name, String type) {
        super(name, type);
    }

    public static void printBystatic(){
        System.out.println("ExChild.printBystatic()");
    }

    public static void main(String[] args) {
        ExChild exChild = new ExChild();
        exChild.printBystatic();
        ExChild name = new ExChild("name");
    }
}
