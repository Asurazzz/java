package com.ymj.c4.test;

/**
 * https://blog.csdn.net/seu_calvin/article/details/52291082
 *
 * @author admin
 */
public class Test {
    public static void main(String[] args) {
//        String str2 = new String("str") + new String("01");
//        String str1 = "str01";
//        str2.intern();
//        System.out.println(str2.intern() == str1); // false


//        String str2 = new String("str") + new String("01");
//        String intern = str2.intern();
//        String str1 = "str01";
//        System.out.println(str2 == str1);// true
//        System.out.println(str2 == intern);

//        String str3 = new String("str01");
//        String intern = str3.intern();
//        String str4 = "str01";
//        System.out.println(intern == str3);
//        System.out.println(intern == str4);// true
//        System.out.println(str3 == str4);

//        String s = new String("abc");
//        String s1 = "abc";
//        String s2 = new String("abc");
//        System.out.println(s == s1); // 堆内存"abc"和常量池"abc"相比,false
//        System.out.println(s == s2); // 堆内存s和堆内存s2相比,false
//        System.out.println(s == s1.intern()); // 堆内存"abc"和常量池"abc"相比,false
//        System.out.println(s == s2.intern()); // 堆内存"abc"和常量池"abc"相比,false
//        System.out.println(s1 == s2.intern()); // 常量池"abc"和常量池"abc"相比,true
//        System.out.println(s.intern() == s2.intern()); // 常量池"abc"和常量池"abc"相比,true


//        String s1 = new String("abc");
//        String s2 = "abc";
//        System.out.println(s1 == s2);


        //String s1 = new String("ab") + new String("c");
//        String s1 = new String("abc");
//        //s1.intern();
//        String s2 = "abc";
//        System.out.println(s1.intern() == s2);
//        System.out.println(s2.intern() == s2);
//        System.out.println(s1 == s2);


//        // 此时堆中存在对象a,b,ab  常量池中有a, b，s3指向堆中的ab
//        String s3 = new String("a") + new String("b");
//        // intern之后发现常量池中没有ab，那么就会在常量池中创建ab，然后地址是指向s3的堆中的地址
//        // s3.intern();
//        // 这个时候已经存在了，就是指向s3的地址
//        String s4 = "ab";
//        System.out.println(s3 == s4);


//        // 堆中创建ab，常量池中创建ab
//        String s1 = new String("ab");
//        // 这个时候发现常量池中已经存在ab了，那么就不再创建了
//        s1.intern();
//        // 这个时候s2还是常量池中的地址
//        String s2= "ab";
//        System.out.println(s2.intern() == s1);


//        // 堆中SEU，Calvin，SEUCalvin，常量池中SEU，Calvin，str1是指向堆中的SEUCalvin
//        String str1 = new String("SEU") + new String("Calvin");
//        // str1.intern() 发现没有SEUCalvin，那么就会创建一个SEUCalvin，地址是堆中的地址
//        System.out.println(str1.intern() == str1);
//
//        System.out.println(str1 == "SEUCalvin");


//        String str1 = new String("SEU")+ new String("Calvin");
//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        //System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");


        // java这个字符串在字符串常量池已经出现过了 有他的引用不符合intern（）的首次遇到原则
        // private static final String launcher_name = "java"; 就是因为这个你可以去搜索 他是个类变量在加载准备阶段就已经给在字符串常量池中创建了希望可以帮助到你
//        String str1 = new String("28") + new String("41");
//        System.out.println(str1.intern() == str1);
//        //System.out.println(str1 == "java");


//        String s10 = new String("计算机");
//        System.out.println(s10.intern() == s10);
//        String s11 = "计算机";
//        System.out.println(s10.intern() == s11);

        String s10 = new String("计算1") + new String("机1");
        // System.out.println(s10.intern() == s10);
        String s11 = "计算1机1";
        System.out.println(s11.intern() == s10);


    }
}
