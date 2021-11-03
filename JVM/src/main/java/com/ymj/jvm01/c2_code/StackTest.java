package com.ymj.jvm01.c2_code;

/**
 * @Classname StackTest
 * @Description TODO
 * @Date 2021/8/12 10:45
 * @Created by yemingjie
 */
public class StackTest {
    static long count = 0;

    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }
}

