package com.ymj.study.Code03_threadpool;

import com.ymj.study.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname TestNewCacheThreadPool
 * @Description 可缓存线程池
 * @Date 2021/7/5 16:07
 * @Created by yemingjie
 */
public class TestNewCacheThreadPool {
    public static final int SLEEP_GAP = 500;

    /**
     * 异步任务的执行目标类
     */
    static class TargetTask implements Runnable {
        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;
        public TargetTask() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }
        @Override
        public void run() {
            Print.tco("任务：" + taskName + " doing");
            // 线程睡眠一会
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Print.tco(taskName + " 运行结束.");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(new TargetTask());
            pool.submit(new TargetTask());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
