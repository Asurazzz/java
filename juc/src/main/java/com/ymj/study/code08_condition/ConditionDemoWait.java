package com.ymj.study.code08_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Classname ConditionDemoWait
 * @Description TODO
 * @Date 2021/7/13 10:26
 * @Created by yemingjie
 */
public class ConditionDemoWait implements Runnable{
    
    private Lock lock;

    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    
    @Override
    public void run() {
        System.out.println("begin - ConditionDemoWait");
        try {
            lock.lock();
            condition.await();
            System.out.println("end - ConditionDemoWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
