package com.ymj.test;

import org.openjdk.jol.info.ClassLayout;

public class CountEmptyObjectSize {
    public static void main(String[] args) {
        // 8 + 4 + 4
        CountEmptyObjectSize objectSize = new CountEmptyObjectSize();
        System.out.println(ClassLayout.parseInstance(objectSize).toPrintable());
    }
}
