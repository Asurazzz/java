package com.ymj.study.code08_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Classname ConditionDemoSignal
 * @Description TODO
 * @Date 2021/7/13 10:30
 * @Created by yemingjie
 */
public class ConditionDemoSignal implements Runnable{

    private Lock lock;
    private Condition condition;
    public ConditionDemoSignal(Lock lock, Condition condition){
        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        System.out.println("begin - ConditionDemoSignal");
        try {
            lock.lock();
            condition.signal();
            System.out.println("end - ConditionDemoSignal");
        } finally {
            lock.unlock();
        }
    }
}
