package com.ymj.study.code10_juc_container;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname CopyOnWriteArrayListTest
 * @Description TODO
 * @Date 2021/7/15 16:01
 * @Created by yemingjie
 */
public class CopyOnWriteArrayListTest {
    public static class ConcurrentTarget implements Runnable {
        //并发操作的目标队列
        List<String> targetList = null;

        public ConcurrentTarget(List<String> targetList) {
            this.targetList = targetList;
        }

        @Override
        public void run() {
            Iterator<String> iterator = targetList.iterator();
            //迭代操作
            while (iterator.hasNext()) {
                // 在迭代操作时，进行列表的修改
                String threadName = Thread.currentThread().getName();
                System.out.println("开始往同步队列加入线程名称：" + threadName);
                targetList.add(threadName);
            }
        }
    }

    public static void main(String[] args) {
        List<String> notSafeList = Arrays.asList("a", "b", "c");
        //创建一个 CopyOnWriteArrayList 队列
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(notSafeList);

        //并发执行目标
        ConcurrentTarget copyOnWriteArrayListDemo =
                new ConcurrentTarget(copyOnWriteArrayList);
        for (int i = 0; i < 10; i++) {
            new Thread(copyOnWriteArrayListDemo, "线程" + i).start();
        }
        //主线程等待
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}