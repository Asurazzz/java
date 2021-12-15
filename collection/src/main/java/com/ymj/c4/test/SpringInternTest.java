package com.ymj.c4.test;

import org.junit.Test;

/**
 * https://blog.csdn.net/seu_calvin/article/details/52291082
 * @author admin
 */
public class SpringInternTest {


    @Test
    public void test1() {
        String str1 = new String("SEU")+ new String("Calvin");
        //String str2 = "SEUCalvin";
        System.out.println(str1.intern() == str1);
        //System.out.println(str1 == "SEUCalvin");
    }
    
    
    @Test
    public void test2() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        // System.out.println(s == s2);
        System.out.println(s.intern() == s2);
    }

    @Test
    public void test3() {
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
