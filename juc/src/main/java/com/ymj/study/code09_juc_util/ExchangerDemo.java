package com.ymj.study.code09_juc_util;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @Classname ExchangerDemo
 * @Description TODO
 * @Date 2021/7/13 17:36
 * @Created by yemingjie
 */
public class ExchangerDemo {
    private static final Random random = new Random();

    public static void main(String[] args) {
        // 建一个多线程共用的exchange对象
        // 把exchange对象传给3个线程对象。每个线程在自己的run方法中调用exchange，把自 己的数据作为参数
        // 传递进去，返回值是另外一个线程调用exchange传进去的参数
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread("线程1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 如果没有其他线程调用exchange，线程阻塞，直到有其他线程调 用exchange为止。
                        String otherData = exchanger.exchange("交换数据1");
                        System.out.println(Thread.currentThread().getName() + "得到<==" + otherData);
                        Thread.sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        new Thread("线程2") {
            @Override
            public void run() {
                while (true) {
                    try {
                        String otherData = exchanger.exchange("交换数据2");
                        System.out.println(Thread.currentThread().getName() + "得到<==" + otherData);
                        Thread.sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("线程3") {
            @Override
            public void run() {
                while (true) {
                    try {
                        String otherData = exchanger.exchange("交换数据3");
                        System.out.println(Thread.currentThread().getName() + "得到<==" + otherData);
                        Thread.sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}


