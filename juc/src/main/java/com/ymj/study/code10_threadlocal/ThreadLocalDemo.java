package com.ymj.study.code10_threadlocal;

/**
 * @author : yemingjie
 * @date : 2021/7/17 15:56
 */
public class ThreadLocalDemo {

    static ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    // 每个线程的变量副本是如何存储的？
    // ThreadLocal是什么时候设置初始化的？

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                // 获得ThreadLocal初始化的值0
                int localNum = num.get();
                localNum = localNum + 5;
                // 设置修改以后的值
                num.set(localNum);
                System.out.println(Thread.currentThread().getName() + ":" + num.get());
            });
        }
        for(Thread thread : threads) {
            thread.start();
        }
    }
}
