package com.ymj.study.code06_reentrantlock;

import com.ymj.study.util.DateUtil;
import com.ymj.study.util.Print;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : yemingjie
 * @date : 2021/7/11 15:19
 */
public class ReadWriteLockTest2 {
    //创建一个 Map，代表共享数据
    final static Map<String, String> MAP = new HashMap<String, String>();
    //创建一个读写锁
    final static ReentrantReadWriteLock LOCK = new
            ReentrantReadWriteLock();
    //获取读锁
    final static Lock READ_LOCK = LOCK.readLock();
    //获取写锁
    final static Lock WRITE_LOCK = LOCK.writeLock();

    public static String getNowTime() {
        //HH表示用24小时制，如18；hh表示用12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }

    //对共享数据的写操作
    public static Object put(String key, String value) {
        WRITE_LOCK.lock();
        try {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  " 抢占了 WRITE_LOCK，开始执行 write 操作");
            Thread.sleep(1000);
            String put = MAP.put(key, value);
            System.out.println("[" + Thread.currentThread().getName() + "]" +  "尝试降级写锁为读锁");
            //写锁降级为读锁（成功）
            READ_LOCK.lock();
            System.out.println("[" + Thread.currentThread().getName() + "]" +  "写锁降级为读锁成功");
            return put;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            READ_LOCK.unlock();
            WRITE_LOCK.unlock();
        }
        return null;
    }


    public static Object get(String key)
    {
        READ_LOCK.lock();
        try
        {
            Print.tco(DateUtil.getNowTime()
                    + " 抢占了 READ_LOCK，开始执行 read 操作");
            Thread.sleep(1000);
            String value = MAP.get(key);
            System.out.println("[" + Thread.currentThread().getName() + "]" +  "尝试升级读锁为写锁");
            // 读锁升级为写锁(失败)
            WRITE_LOCK.lock();
            System.out.println("[" + Thread.currentThread().getName() + "]" +  "读锁升级为写锁成功");
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            WRITE_LOCK.unlock();
            READ_LOCK.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        //创建 Runnable 可执行实例
        Runnable writeTarget = () -> put("key", "value");
        Runnable readTarget = () -> get("key");
        //创建 1 条写线程，并启动
        new Thread(writeTarget, "写线程").start();
        //创建 1 条读线程
        new Thread(readTarget, "读线程").start();
    }
}
