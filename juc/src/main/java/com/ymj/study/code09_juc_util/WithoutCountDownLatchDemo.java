package com.ymj.study.code09_juc_util;

/**
 * @Classname WithoutCountDownLatchDemo
 * @Description 不使用闭锁
 * @Date 2021/7/13 15:26
 * @Created by yemingjie
 */
public class WithoutCountDownLatchDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "同学离开了");
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + "要关门了，此时教室已经没有人了~");
    }
}
