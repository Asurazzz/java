package com.ymj.study.code05_synchronized;

/**
 * @Classname SynchronizedDemo
 * @Description TODO
 * @Date 2021/7/8 11:48
 * @Created by yemingjie
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("HelloWorld");
        }
    }
}
