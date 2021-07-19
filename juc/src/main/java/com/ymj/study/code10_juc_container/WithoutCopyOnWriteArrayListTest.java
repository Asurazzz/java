package com.ymj.study.code10_juc_container;

import com.ymj.study.util.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname CopyOnWriteArrayListTest
 * @Description TODO
 * @Date 2021/7/15 15:47
 * @Created by yemingjie
 */
public class WithoutCopyOnWriteArrayListTest {

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

        //测试同步队列：在迭代操作时，进行列表的修改
        public static void main(String[] args) {
            List<String> notSafeList = Arrays.asList("a", "b", "c");
            List<String> synList = Collections.synchronizedList(notSafeList);
            //创建一个执行目标
            ConcurrentTarget synchronizedListListDemo =
                    new ConcurrentTarget(synList);
            //10 个线程并发
            for (int i = 0; i < 10; i++) {
                new Thread(synchronizedListListDemo , "线程" + i).start();
            }
            //主线程等待
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
