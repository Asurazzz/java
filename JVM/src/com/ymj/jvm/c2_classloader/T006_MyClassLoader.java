package com.ymj.jvm.c2_classloader;

/**
 * @author : yemingjie
 * @date : 2021/7/1 21:45
 */
public class T006_MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String s) throws ClassNotFoundException {
        return super.findClass(s);
    }
}
