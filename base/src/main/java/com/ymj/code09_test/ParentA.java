package com.ymj.code09_test;

public class ParentA {
    static {
        System.out.println("1");
    }

    {
        System.out.println("aaaaa");
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
        // 1 a aaaa 2 
        ParentA ab = new ParentA();
        ab = new SonB(); // 1 a aaaa 2 aaaa 2 b
    }
}
