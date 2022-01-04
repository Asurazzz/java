package com.ymj.code00.test03;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author admin
 * @version 1.0
 * @date 2022/1/4 15:54
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println("未进入同步块，MarkWord 为：");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println("进入同步块，MarkWord 为：");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
