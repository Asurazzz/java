package com.ymj.study.Code03_threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadPoolExecutorDemo
 * @Description TODO
 * @Date 2021/7/5 17:21
 * @Created by yemingjie
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.AbortPolicy()
                // new ThreadPoolExecutor.CallerRunsPolicy()
                // new ThreadPoolExecutor.DiscardOldestPolicy()
                //new ThreadPoolExecutor.DiscardPolicy()
        );


        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getId() + "[" + finalI + "] -- 开始");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "[" + finalI + "] -- 结束");
            });
            try {Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        executor.shutdown();
        boolean flag = true;

        try {
            do {
                flag = !executor.awaitTermination(1, TimeUnit.SECONDS);
            } while (flag);
        } catch  (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程池关闭成功。。。");
        System.out.println(Thread.currentThread().getId());
    }
}
