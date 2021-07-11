package com.ymj.study.code06_reentrantlock;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author : yemingjie
 * @date : 2021/7/11 15:32
 */
public class StampedLockTest {
    //创建一个 Map，代表共享数据
    final static Map<String, String> MAP = new HashMap<String, String>();
    //创建一个印戳锁
    final static StampedLock STAMPED_LOCK = new StampedLock();

    public static String getNowTime() {
        //HH表示用24小时制，如18；hh表示用12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }
    public static void sleepSeconds(int second) {
        LockSupport.parkNanos(second * 1000L * 1000L * 1000L);
    }

    //对共享数据的写操作
    public static Object put(String key, String value) {
        //尝试获取写锁的印戳
        long stamp = STAMPED_LOCK.writeLock();
        try {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  " 抢占了 WRITE_LOCK，开始执行 write 操作");
            Thread.sleep(1000);
            String put = MAP.put(key, value);
            return put;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  "  释放了 WRITE_LOCK");
            //释放写锁
            STAMPED_LOCK.unlockWrite(stamp);
        }
        return null;
    }

    //对共享数据的悲观读操作
    public static Object pessimisticRead(String key) {
        System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  "LOCK 进入过写模式，只能悲观读");
        //进入了写锁模式，只能获取悲观读锁
        //尝试获取读锁的印戳
        long stamp = STAMPED_LOCK.readLock();
        try {
            //成功获取到读锁，并重新获取最新的变量值
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  " 抢占了 READ_LOCK");
            String value = MAP.get(key);
            return value;
        } finally {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  " 释放了 READ_LOCK");
            //释放读锁
            STAMPED_LOCK.unlockRead(stamp);

        }
    }

    //对共享数据的乐观读操作
    public static Object optimisticRead(String key) {
        String value = null;
        //尝试进行乐观读
        long stamp = STAMPED_LOCK.tryOptimisticRead();
        if (0 != stamp) {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  "乐观读的印戳值，获取成功");
            //模拟耗费时间 1 秒
            sleepSeconds(1);
            value = MAP.get(key);
        } else {// 0 == stamp 表示当前为写锁模式
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  "乐观读的印戳值，获取失败");
            //LOCK 已经进入写模式，使用悲观读方法
            return pessimisticRead(key);
        }
        //乐观读操作已经间隔了一段时间，期间可能发生写入
        //所以，需要验证乐观读的印戳值是否有效，即判断 LOCK 是否进入过写模式
        if (!STAMPED_LOCK.validate(stamp)) {
            //乐观读的印戳值无效，表明写锁被占用过
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  "乐观读的印戳值，已经过期");
            //写锁已经被抢占，进入了写锁模式，只能通过悲观读锁，再一次读取最新值
            return pessimisticRead(key);
        } else {
            //乐观读的印戳值有效，表明写锁没有被占用过
            //不用加悲观读锁而直接读，减少了读锁的开销
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() +  " 乐观读的印戳值，没有过期");
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建 Runnable 可执行实例
        Runnable writeTarget = () -> put("key", "value");
        Runnable readTarget = () -> optimisticRead("key");
        //创建 1 条写线程，并启动
        new Thread(writeTarget, "写线程").start();
        //创建 1 条读线程
        new Thread(readTarget, "读线程").start();
    }
}
