package com.ymj.code00.test03;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/29 17:29
 *
 * ====使用0.14版本的jol
 * 01 代表无锁的状态
 * 00 代表轻量级锁
 * ====使用0.16版本的jol
 * non-biasable 无锁的状态
 * thin lock： 轻量级锁
 *
 * JDK 1.6 之后默认是开启偏向锁的，为什么初始化的代码是无锁状态，进入同步块产生竞争就绕过偏向锁直接变成轻量级锁了呢？
 * 虽然默认开启了偏向锁，但是开启有延迟，大概 4s。原因是 JVM 内部的代码有很多地方用到了synchronized，
 * 如果直接开启偏向，产生竞争就要有锁升级，会带来额外的性能损耗，所以就有了延迟策略
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("未进入同步块，MarkWord 为：");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println("进入同步块，MarkWord 为：");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
