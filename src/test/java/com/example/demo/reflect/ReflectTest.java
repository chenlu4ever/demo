package com.example.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 10450
 * @description TODO
 * @date 2021/12/21 14:53
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c1 = Class.forName("com.example.demo.reflect.ReflectVO");
        Method sayHi = c1.getMethod("sayHi", new Class[] {String.class});
        sayHi.invoke(c1.newInstance(),new Object[] { new String("周杰伦")});

//        //第二种
//        ReflectVO p = new ReflectVO();
//        Class c2 = p.getClass();
//        //第三种
//        Class c3 = ReflectVO.class;
    }
}
