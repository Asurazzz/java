package com.ymj.jvm01.c5_code;

/**
 * @Classname ClassLoaderTest
 * @Description TODO
 * @Date 2021/8/13 16:52
 * @Created by yemingjie
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader("d:/");
        try {
            Class<?> clazz= classLoader.loadClass("TestMain");
            System.out.println("我是由"+clazz.getClassLoader().getClass().getName()+"类加载器加载 的");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
