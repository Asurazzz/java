package com.ymj.c4.test;

/**
 * @author admin
 */
public class StringInternTest2 {
    public static void main(String[] args) {
        String a = "aa";
        System.out.println(a.intern() == a);
    }
}
