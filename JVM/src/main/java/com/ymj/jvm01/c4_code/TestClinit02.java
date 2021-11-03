package com.ymj.jvm01.c4_code;

/**
 * @Classname TestClinit02
 * @Description TODO
 * @Date 2021/8/13 15:31
 * @Created by yemingjie
 */
public class TestClinit02 {

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
