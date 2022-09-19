//package com.example.demo.test;
//
//import sun.misc.Launcher;
//import sun.misc.MetaIndex;
//import sun.misc.Resource;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.security.AccessController;
//import java.security.PrivilegedExceptionAction;
//
///**
// * @author 10450
// * @description 自定义类加载
// * @date 2022/8/24 15:24
// */
//public class MyClassLoaderTest {
//    static class MyClassLoader extends ClassLoader {
//        private  String classPath;
//
//        public MyClassLoader(String classPath){
//            this.classPath=classPath;
//        }
//
//        private  byte[] loadByte(String name)throws Exception{
//            name = name.replaceAll("\\.","/");
//            FileInputStream in = new FileInputStream(classPath+"/"+name+".class");
//            int len = in.available();
//            byte[] data = new byte[len];
//            in.read(data);
//            in.close();
//            return data;
//        }
//
//        /**
//         * 自定义类加载，重写findClass
//         * @param name
//         * @return
//         * @throws ClassNotFoundException
//         */
//        protected Class<?> findClass(final String name)
//                throws ClassNotFoundException
//        {
//            try {
//                byte[] data= loadByte(name);
//                return  defineClass(name,data,0,data.length);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//
//        /**
//         * 打破双亲委派机制，
//         * @param name
//         * @param resolve
//         * @return
//         * @throws ClassNotFoundException
//         */
//        protected Class<?> loadClass(String name, boolean resolve)
//                throws ClassNotFoundException
//        {
//            synchronized (getClassLoadingLock(name)) {
//                // First, check if the class has already been loaded
//                Class<?> c = findLoadedClass(name);
//                long t0 = System.nanoTime();
//                if (c == null) {
//                    // If still not found, then invoke findClass in order
//                    // to find the class.
//                    long t1 = System.nanoTime();
//                    if(name.startsWith("com.example.demo.test")){
//                        c = findClass(name);
//                    }else{
//                        c = this.getParent().loadClass(name);
//                    }
//
//                    // this is the defining class loader; record the stats
//                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
//                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//                    sun.misc.PerfCounter.getFindClasses().increment();
//                }
//                if (resolve) {
//                    resolveClass(c);
//                }
//                return c;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception{
//        MyClassLoader myClassLoader = new MyClassLoader("D:/");
//        Class clazz = myClassLoader.loadClass("com.example.demo.test.MySout");
//        Object object = clazz.newInstance();
//        Method method = clazz.getDeclaredMethod("printin",null);
//        method.invoke(object,null);
//        System.out.println(clazz.getClassLoader().getClass().getName());
//
////        MyClassLoader myClassLoader1 = new MyClassLoader("E:/");
////        Class clazz1 = myClassLoader1.loadClass("com.example.demo.test.MySout");
////        Object object1 = clazz1.newInstance();
////        Method method1 = clazz1.getDeclaredMethod("printin",null);
////        method1.invoke(object1,null);
////        System.out.println(clazz1.getClassLoader().getClass().getName());
//    }
//}
