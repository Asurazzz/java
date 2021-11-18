package com.ymj;

public class StringTest {
    public static void main(String[] args) {
        //Java中有常量优化机制，“a”、“b”、“c”本身就是字符串常量，所以在编译时，"a"+"b"+"c"就是“abc”字符串，
        // 所以就在常量池创建了“abc”字符串，当执行s2的时候，此时常量池中已经存在了“abc”，
        // 所以==号比较返回true。equals方法比较毫无疑问是true。
//        String s1 = "a" + "b" + "c";
//        String s2 = "abc";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        System.out.println("=======================");
        // s1+"c"中s1不是常量，所以不能有常量优化机制来分析。equals方法比较毫无疑问是true。
        //s1和s2会分别在常量池中创创建"ab"、"abc"两个对象
        //s3的时候是字符串串联，API解释如下图。所以s3的时候会在对内存中创建StringBuilder(或者StringBuffer)对象，
        // 通过append方法拼接成“abc”对象，此时的“abc”是StringBuilder(或者StringBuffer)类型的，
        // 通过调用toString方法转成String对象，此时s3指向的是堆内存中这个String对象
        //s2指向的是常量池中的对象，s3指向的是堆内存中的对象，所以==号比较返回false
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        String s4 = "ab" + "c";

        System.out.println(s4 == s4);
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2));

    }
}
