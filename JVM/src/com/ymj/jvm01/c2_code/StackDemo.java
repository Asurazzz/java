package com.ymj.jvm01.c2_code;

/**
 * @Classname StackDemo
 * @Description TODO
 * @Date 2021/8/12 10:35
 * @Created by yemingjie
 */
public class StackDemo {
    public static void main(String[] args) {
        StackDemo sd = new StackDemo();
        sd.A();
    }

    private void A() {
        int a = 10;
        System.out.println(" method A start!");
        System.out.println(a);
        B();
        System.out.println(" method A end!");
    }

    private void B() {
        int b = 20;
        System.out.println(" method B start!");
        C();
        System.out.println(" method B end!");
    }

    private void C() {
        int c = 30;
        System.out.println(" method C start!");
        System.out.println(" method C end!");
    }
}
