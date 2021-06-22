package com.ymj.bfbcys.test03_castest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname CASTest
 * @Description 实现了一个基于CAS线程安全的计数器 方法safeCount和一个非线程安全的计数器count。
 * @Date 2021/6/22 11:31
 * @Created by yemingjie
 */
public class CASTest {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final CASTest cas = new CASTest();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }

        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    /**
     * 使用CAS实现线程安全计数器
     */
    private void safeCount() {
        for (;;) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
