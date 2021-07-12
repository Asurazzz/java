package com.ymj.study.code06_reentrantlock;

import com.ymj.study.util.DateUtil;
import com.ymj.study.util.Print;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : yemingjie
 * @date : 2021/7/11 15:03
 */
public class ReadWriteLockTest {
    //创建一个 Map，代表共享数据
    final static Map<String, String> MAP = new HashMap<String, String>();
    //创建一个读写锁
    final static ReentrantReadWriteLock LOCK = new
            ReentrantReadWriteLock();
    //获取读锁
    final static Lock READ_LOCK = LOCK.readLock();
    //获取写锁
    final static Lock WRITE_LOCK = LOCK.writeLock();

    //对共享数据的写操作
    public static Object put(String key, String value) {
        //抢写锁
        WRITE_LOCK.lock();
        try {
            System.out.println("[" + Thread.currentThread().getName() + "]" + getNowTime() + " 抢占了 WRITE_LOCK，开始执行 write 操作");
            Thread.sleep(1000);
            //写入共享数据
            String put = MAP.put(key, value);
            return put;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            WRITE_LOCK.unlock();
        }
        return null;
    }

    //对共享数据的读操作
    public static Object get(String key) {
        //抢占读锁
        READ_LOCK.lock();
        try {
            System.out.println("[" + Thread.currentThread().getName() + "]"  + getNowTime() + " 抢占了 READ_LOCK，开始执行 read 操作");
            Thread.sleep(1000);
            //读取共享数据
            String value = MAP.get(key);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放读锁
            READ_LOCK.unlock();
        }
        return null;
    }

    public static String getNowTime() {
        //HH表示用24小时制，如18；hh表示用12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        //创建 Runnable 异步可执行目标实例
        Runnable writeTarget = () -> put("key", "value");
        Runnable readTarget = () -> get("key");
        //创建 4 条读线程
        for (int i = 0; i < 4; i++) {
            new Thread(readTarget, "读线程" + i).start();
        }
        //创建 2 条写线程，并启动
        for (int i = 0; i < 2; i++) {
            new Thread(writeTarget, "写线程" + i).start();
        }
    }
}
