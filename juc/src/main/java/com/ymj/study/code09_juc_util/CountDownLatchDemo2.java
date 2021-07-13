package com.ymj.study.code09_juc_util;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchDemo2
 * @Description TODO
 * @Date 2021/7/13 15:32
 * @Created by yemingjie
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(() -> {
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"t1").start();
        new Thread(()->{
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"t2").start();
        new Thread(()->{
            System.out.println(""+Thread.currentThread().getName()+"-执行中");
            countDownLatch.countDown();
            System.out.println(""+Thread.currentThread().getName()+"-执行完毕");
        },"t3").start();
        countDownLatch.await();
        System.out.println("所有线程执行完毕");
    }
}
