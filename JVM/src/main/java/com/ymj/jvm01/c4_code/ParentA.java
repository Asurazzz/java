package com.ymj.jvm01.c4_code;

/**
 * @Classname ParentA
 * @Description TODO
 * @Date 2021/8/13 15:50
 * @Created by yemingjie
 */
public class ParentA {
    static {
        System.out.println("1");
    }

    public ParentA() {
        System.out.println("2");
    }

}

class SonB extends ParentA {
    static {
        System.out.println("a");
    }

    public SonB() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        ParentA ab = new SonB();
        ab = new SonB();
    }
}
