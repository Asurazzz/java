package com.ymj.c4.test;

public class StringTest5 {
    public static void main(String[] args) {
        char[] cs = {'熊', '猫'};
        String s7 = new String(cs);
        System.out.println(s7.intern() == s7);// true

        String s9 = "熊猫";
        System.out.println(s7.intern() == s9); // true


        String s10 = new String("计算机");
        System.out.println(s10.intern() == s10);//false
        String s11 = "计算机";
        System.out.println(s10.intern() == s11);//true


        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("go").append("od").toString();
        System.out.println(s2.intern() == s2);
    }
}
