package com.ymj.code09_test;

public class HelloB extends HelloA{
    public HelloB() {
        System.out.println("B的构造方法");
    }
    {
        System.out.println("B的构造代码块");
    }
    static {
        System.out.println("B的静态代码块");
    }

    public static HelloB hB = new HelloB();

    public static void main(String[] args) {
        new HelloB();
    }
}

class HelloA {
    public HelloA() {
        System.out.println("A的构造方法");
    }
    {
        System.out.println("A的构造代码块");
    }
    static {
        System.out.println("A的静态代码块");
    }
}
