package com.ymj;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        long h = 2L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); // false
        System.out.println(g.equals(a + h)); // true


        System.out.println("==============================");
        Integer a1 = new Integer(3);
        Integer b1 = 3; // 将3自动装箱成Integer类型
        int c1 = 3;
        System.out.println(a1 == b1);
        System.out.println(a1 == c1);

        System.out.println("==============================");
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}
