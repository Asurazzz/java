package com.ymj.study.code09_juc_util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/7/13 16:20
 * @Created by yemingjie
 */
public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new MyThread("线程-" + (i + 1), barrier).start();
        }
    }
}
