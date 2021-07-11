package com.ymj.study.code06_reentrantlock;

/**
 * @author : yemingjie
 * @date : 2021/7/11 14:40
 */
public class ReentrantDemo {
    public synchronized void demo() {
        System.out.println("begin: demo");
        demo2();
    }

    public void demo2() {
        System.out.println("begin: demo2");
        synchronized (this) {

        }
    }

    public static void main(String[] args) {
        ReentrantDemo rd=new ReentrantDemo();
        new Thread(rd::demo).start();
    }
}
