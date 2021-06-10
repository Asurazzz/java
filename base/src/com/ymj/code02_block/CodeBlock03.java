package com.ymj.code02_block;

/**
 * @Classname CodeBlock03
 * @Description TODO
 * @Date 2021/6/10 9:46
 * @Created by yemingjie
 */
public class CodeBlock03 {
    {
        System.out.println("CodeBlock03的构造代码块2222");
    }
    static {
        System.out.println("CodeBlock03的静态代码块3333");
    }

    public CodeBlock03() {
        System.out.println("CodeBlock03的构造方法33333");
    }

    public static void main(String[] args) {
        System.out.println("我是主类===============");
        new Code();
        System.out.println("=================");
        new Code();
        System.out.println("=================");
        new CodeBlock03();
    }
}

class Code {
    public Code() {
        System.out.println("Code的构造方法1111");
    }

    {
        System.out.println("Code的构造代码块2222");
    }
    static {
        System.out.println("Code的静态代码块3333");
    }
}
