package com.ymj.jvm01.c3_code;

import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @Classname DirectMemoryOOM
 * @Description TODO
 * @Date 2021/8/12 17:25
 * @Created by yemingjie
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    // VM Args： -Xmx20M -XX:MaxDirectMemorySize=10M
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
