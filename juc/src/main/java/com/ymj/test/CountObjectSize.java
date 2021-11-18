package com.ymj.test;

import org.openjdk.jol.info.ClassLayout;

public class CountObjectSize {
    int a = 10; // 4
    int b = 20; // 4
    // 8+4+0+4+4=24
    public static void main(String[] args) {
        CountObjectSize object = new CountObjectSize();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
