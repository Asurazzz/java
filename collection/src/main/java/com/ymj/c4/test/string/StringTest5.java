package com.ymj.c4.test.string;

import org.junit.Test;

/**
 * @author yemingjie
 */
public class StringTest5 {

    @Test
    public void test1() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";

        /**
         * 最终.java编译成.class，再执行.class
         */
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }


    /**
     * 拼接的时候只要有一个是变量，那么结果就在堆中
     */
    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s6.intern();
        System.out.println(s3 == s8);


    }


    /**
     * 字符串拼接操作不一定使用的是StringBuilder
     * 如果拼接符号左右两边都是字符串常量或者常量引用，
     * 仍然使用编译期优化
     */
    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }
}
