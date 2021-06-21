package com.ymj.study.code01_stackarea;

/**
 * @Classname StackAreaDemo
 * @Description 演示一个 Java 程序的线程信息
 * @Date 2021/6/18 15:24
 * @Created by yemingjie
 */
public class StackAreaDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("当前线程名称："+Thread.currentThread().getName());
        System.out.println("当前线程ID："+Thread.currentThread().getId());
        System.out.println("当前线程状态："+Thread.currentThread().getState());
        System.out.println("当前线程优先级："+Thread.currentThread().getPriority());
        int a = 3, b = 1;
        int c = a / b;
        anotherFun();
        Thread.sleep(1000);
        System.out.println(c);
    }

    private static void anotherFun() {
        int a = 1, b = 1;
        int c = a / b;
        anotherFun2();
    }

    private static void anotherFun2() {
        int a = 2, b = 1;
        int c  = a / b;
    }
}
