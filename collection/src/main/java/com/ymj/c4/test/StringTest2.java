package com.ymj.c4.test;

/**
 *
 *
 * https://blog.csdn.net/qq_34115899/article/details/86536409   JVM内存的基本问题
 * https://blog.csdn.net/qq_34115899/article/details/86583262
 * https://www.cnblogs.com/flyingrun/p/12781257.html
 *
 * b.intern() == a和b.intern() == c可知，采用new 创建的字符串对象不进入字符串池
 * 通过b.intern() == d和b.intern() == f可知，字符串相加的时候，都是静态字符串的结果会添加到字符串池
 * 如果其中含有变量（如f中的e）则不会进入字符串池中
 */
public class StringTest2 {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;


        // false
        System.out.println(b == a.intern());
        // true
        System.out.println(b.intern() == c);
        // true
        System.out.println(b.intern() == d);
        // false
        System.out.println(b.intern() == f);
        // true
        System.out.println(b.intern() == a.intern());
    }
}
