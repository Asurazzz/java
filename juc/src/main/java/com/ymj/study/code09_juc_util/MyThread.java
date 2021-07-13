package com.ymj.study.code09_juc_util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MyThread
 * @Description TODO
 * @Date 2021/7/13 16:18
 * @Created by yemingjie
 */
public class MyThread extends Thread{

    private final CyclicBarrier barrier;
    private final Random random = new Random();
    public MyThread(String name, CyclicBarrier barrier) {
        super(name);
        this.barrier = barrier;
    }
    @Override public void run() {
        try {
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName() + " - 已经到达公司");
            barrier.await();
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName() + " - 已经笔试结束");
            barrier.await();
            Thread.sleep(random.nextInt(2000));
            System.out.println(Thread.currentThread().getName() + " - 已经面试结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        super.run();
    }
}



