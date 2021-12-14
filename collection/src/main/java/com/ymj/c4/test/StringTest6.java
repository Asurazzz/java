package com.ymj.c4.test;

/**
 * 补充：解答上面的面试题需要清除两点：1. String 对象的 intern 方法会得到字符
 * 串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与 String 对象
 * 的 equals 结果是 true），如果常量池中没有对应的字符串，则该字符串将被添加
 * 到常量池中，然后返回常量池中字符串的引用；2. 字符串的+操作其本质是创建
 * 了 StringBuilder 对象进行 append 操作，然后将拼接后的 StringBuilder 对象用
 * toString 方法处理成 String 对象，这一点可以用 javap -c StringEqualTest.class
 * 命令获得 class 文件对应的 JVM 字节码指令就可以看出来。
 * @author admin
 */
public class StringTest6 {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);// false
        System.out.println(s1 == s5);// true
        System.out.println(s1 == s6); // false
        System.out.println(s1 == s6.intern()); // true
        System.out.println(s2 == s2.intern()); //false
    }
}
