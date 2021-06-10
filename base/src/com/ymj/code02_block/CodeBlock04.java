package com.ymj.code02_block;

/**
 * @Classname CodeBlock04
 * @Description TODO
 * @Date 2021/6/10 10:19
 * @Created by yemingjie
 */
public class CodeBlock04 {
    public static void main(String[] args) {

        System.out.println("我是主类======");
        new Son();
        System.out.println("======");
        new Son();
        System.out.println("======");
        new Father();
    }
}

class Father {
    {
        System.out.println("我是父亲代码块");
    }
    public Father() {
        System.out.println("我是父亲构造");
    }
    static {
        System.out.println("我是父亲静态代码块");
    }
}

class Son extends Father{
    public Son() {
        System.out.println("我是儿子构造");
    }
    {
        System.out.println("我是儿子代码块");
    }

    static {
        System.out.println("我是儿子静态代码块");
    }
}
