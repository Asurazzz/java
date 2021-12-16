package com.ymj.c4.test;

public class StringTest7 {

    public static void main(String[] args) {
        // Stringbu ,ab,ab ,c ,c ,abc
//        String s1 = new String("ab") + new String("c");
//        String s2 = "abc";
//        //System.out.println(s1 == s2); // false
//        System.out.println(s1.intern() == s1);
//        System.out.println(s1.intern() == s2);


//        String s1 = "ab" + "c";
//        String s2 = "abc";
//        System.out.println(s1 == s2);// true


        String s1 = new String("abc");
        String s2 = "abc";
        //System.out.println(s1.intern() == s1);
        System.out.println(s1.intern() == s2);

    }
}
