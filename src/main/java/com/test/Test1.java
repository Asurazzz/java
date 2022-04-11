package com.test;

public class Test1 {
    public static void main(String[] args) {
        new HelloA();
        System.out.println("======");
        new HelloA();
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


