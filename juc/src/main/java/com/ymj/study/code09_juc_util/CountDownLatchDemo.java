package com.ymj.study.code09_juc_util;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchDemo
 * @Description TODO
 * @Date 2021/7/13 15:25
 * @Created by yemingjie
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"同学离开了");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"要关门了,此时教室已经没人了~");
    }
}
