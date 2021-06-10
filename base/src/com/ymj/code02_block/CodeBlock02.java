package com.ymj.code02_block;

/**
 * @Classname CodeBlock02
 * @Description TODO
 *  启动调用的就是这个类的构造方法，但是比构造方法更上一级的是跟本构造方法在同一个类的代码块，因此
 *      代码块的优先级比构造方法高
 *      构造代码块在每次创建对象的时候都会被调用，并且构造代码块的执行次序优先于构造方法
 * @Date 2021/6/10 9:43
 * @Created by yemingjie
 */
public class CodeBlock02 {
    {
        System.out.println("第二构造块33333");
    }

    public CodeBlock02() {
        System.out.println("构造代码块2222");
    }

    {
        System.out.println("第一代码块33333");
    }

    public static void main(String[] args) {
        new CodeBlock02();
        System.out.println("==========");
        new CodeBlock02();
    }
}
