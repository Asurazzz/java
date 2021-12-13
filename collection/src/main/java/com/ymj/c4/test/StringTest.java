package com.ymj.c4.test;

import java.lang.reflect.Field;

/**
 * @author admin
 */
public class StringTest {
    public static void main(String[] args) throws Exception {
        String str = "vae";
        System.out.println(str);
        Field fieldStr = String.class.getDeclaredField("value");
        fieldStr.setAccessible(true);
        char[] value = (char[]) fieldStr.get(str);
        value[0] = 'V';
        System.out.println(str);
    }
}
