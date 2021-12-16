package com.ymj.c4.test;

/**
 * @author admin
 */
public class StringTestAll {
    public static void main(String[] args) {

        // 普通
//        String s1 = new String("abc");
//        String s2 = "abc";
//        System.out.println(s1 == s2);

//        String s1 = new String("ab") + new String("c");
//        String s2 = "abc";
//        System.out.println(s1 == s2);

//        String s1 = new String("abc");
//        System.out.println(s1.intern() == s1);

//        String s1 = new String("ab") + new String("c");
//        System.out.println(s1.intern() == s1);

//        String s1 = new String("abc");
//        s1.intern();
//        String s2 = "abc";
//        System.out.println(s1 == s2);
//        System.out.println(s1.intern() == s2);
//        System.out.println(s2.intern() == s1);


        // 不加s1.intern() false， 加了就是true，s1.intern放在s2后面就是false
        // 什么都不加，判断s1.intern == s2就是true
        // 不加String s2 = "abc"，直接判断s1.intern() == s1 为true
        // 加String s2 = "abc"后判断s1.intern() == s1为false
        // 只判断s1.intern() == s2 就是true
        // 只判断s1 == s2.intern() 就是false
//        String s1 = new String("ab") + new String("c");
//        //s1.intern();
//        String s2 = "abc";
//        //s1.intern();
//        //System.out.println(s1.intern() == s1);
//        //System.out.println(s1.intern() == s2);
//        System.out.println(s1 == s2.intern());



//        // s1.intern的位置对结果没有影响
//        String s1 = new String("abc");
//        //s1.intern();
//        String s2 = "abc";
//        System.out.println(s1 == s2);
//        System.out.println(s1.intern() == s1);


    }
}
