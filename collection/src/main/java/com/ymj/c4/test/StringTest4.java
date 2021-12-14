package com.ymj.c4.test;

public class StringTest4 {
    public static void main(String[] args) {
        String s1 = new String("d") + new String("dd");
        String s2= "ddd";
        System.out.println(s1.intern() == s2);

        String s3 = new String("ddd");
        String s4 = "ddd";
        System.out.println(s3.intern() == s4);


        String s5 = new String("d") + new String("dd");
        String s6 = "ddd";
        System.out.println(s5.intern() == s6);
    }
}
