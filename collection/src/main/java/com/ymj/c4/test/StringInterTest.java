package com.ymj.c4.test;

public class StringInterTest {
    public static void main(String[] args) {

        String h = new String("cc");
        String intern = h.intern();
        System.out.println(intern == h);


        String a1 = new String("a");
        String a2 = "a";

        System.out.println(a1.intern() == a2);

//
//        String str2 = new String("str") + new String("01");
//        String str1 = "str01";
//        str2.intern();
//        System.out.println(str2.intern() == str1);

        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);

        String str3 = new String("str01");
        str3.intern();
        String str4 = "str01";
        System.out.println(str3 == str4);


//        String s1 = "abc";
//        String s2 = "a";
//        String s3 = "bc";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4);


        String S1 = "abc";
        final String S2 = "a";
        final String S3 = "bc";
        String S4 = S2 + S3;
        System.out.println(S1 == S4);
    }
}
