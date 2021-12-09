package com.ymj.study01.code03;

public class Test2 {
    private static int j = 0;

    private static Boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);

    }

    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);

        String a = "0123456789";
        String substring = a.substring(5);
        System.out.println(substring);
    }
}
