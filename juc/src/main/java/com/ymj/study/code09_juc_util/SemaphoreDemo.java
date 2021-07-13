package com.ymj.study.code09_juc_util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Classname SemaphoreDemo
 * @Description TODO
 * @Date 2021/7/13 17:22
 * @Created by yemingjie
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//此时海底捞有3个空桌
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("第"+Thread.currentThread().getName()+"等待者抢到座位。");
                    //假设每桌客人吃饭时间为3S
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("第"+Thread.currentThread().getName()+"客人吃完饭离开。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
