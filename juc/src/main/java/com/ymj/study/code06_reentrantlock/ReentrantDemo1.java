package com.ymj.study.code06_reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : yemingjie
 * @date : 2021/7/11 14:47
 */
public class ReentrantDemo1 {
    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        lock.lock(); //step1：抢占锁
//        try {
//            //step2：抢锁成功，执行临界区代码
//        } finally {
//            lock.unlock(); //step3：释放锁
//        }

//        Lock lock = new ReentrantLock();
//        if (lock.tryLock()) { //step1：尝试抢占锁
//            try {
//                //step2：抢锁成功，执行临界区代码
//            } finally {
//                lock.unlock(); //step3：释放锁
//            }
//        } else {
//            //step4：抢锁失败，执行后备动作
//        }

//        Lock lock = new ReentrantLock();
//        if (lock.tryLock(1, TimeUnit.SECONDS)) {
//            try {
//                //step2：抢锁成功，执行临界区代码
//            } finally {
//                lock.unlock(); //step3：释放锁
//            }
//        } else {
//            //step4：抢锁失败，执行后备动作
//        }
    }


}


