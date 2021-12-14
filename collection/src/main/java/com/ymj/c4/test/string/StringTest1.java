package com.ymj.c4.test.string;

import org.junit.Test;

/**
 * 体现了string的不可变性
 */
public class StringTest1 {

    @Test
    public void test1() {

        // 字面量定义的方式，“abc”存储在字符串常量池里，字符串常量池不允许放相同的字符串的
        // 运行时常量池在方法区域，字符串常量池在堆中
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }


    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def";
        System.out.println(s2);
        System.out.println(s1);
    }

    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1);
        System.out.println(s2);
    }
}
