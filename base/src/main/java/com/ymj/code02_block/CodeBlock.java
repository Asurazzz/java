package com.ymj.code02_block;

/**
 * @Classname CodeBlock
 * @Description TODO
 *  普通代码块：在方法或语句中出现的{}，就被称为代码块
 *  静态代码块：静态代码块有且仅加载一次，也就是在这个类被加载至内存的时候
 *  普通代码块和一般语句执行顺序由他们在代码中出现的次序决定，先出现先执行
 * @Date 2021/6/10 9:37
 * @Created by yemingjie
 */
public class CodeBlock {
    public static void main(String[] args) {
        {
            int x = 11;
            System.out.println("普通代码块中的变量x=" + x);
        }
        {
            int y = 13;
            System.out.println("普通代码块中的变量y=" + y);
        }
        int x = 12;
        System.out.println("主方法中的变量z = " + x);
    }
}
