package com.ymj.code00.test03;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/29 17:35
 * 延迟5s之后创建对象，看看偏向锁是否生效
 * biasable:可偏向
 * biased：已偏向
 */
public class Test2 {
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
