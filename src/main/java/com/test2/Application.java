package com.test2;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author yemingjie.
 * @date 2022/4/09.
 * @time 11:36.
 */
public class Application {
    public static void main(String[] args) {
        // 1.配置Redis-Cluster集群节点的ip和port
        Config config = new Config();
        // redis-cluster集群的ip和port
        config.useClusterServers()
                .addNodeAddress("redis://192.168.43.159:7001")
                .addNodeAddress("redis://192.168.43.159:7002")
                .addNodeAddress("redis://192.168.43.159:7003")
                .addNodeAddress("redis://192.168.43.114:7001")
                .addNodeAddress("redis://192.168.43.114:7002")
                .addNodeAddress("redis://192.168.43.114:7003");
        //2.通过以上配置创建Redisson的客户端
        RedissonClient redisson = Redisson.create(config);
        //3.测试Redisson可重入锁的加锁、释放锁等功能
        testRedissonSimpleLock(redisson);
        testRedissonSimpleTryLock(redisson);

    }

    /**
     * lock方式
     * @param redisson
     */
    private static void testRedissonSimpleLock(RedissonClient redisson) {
        // 获取key为anyLock的锁对象
        RLock rLock = redisson.getLock("anyLock");
        // 加锁
        rLock.lock();
        try {
            // TODO
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放锁
            rLock.unlock();
        }

    }

    /**
     * tryLock方式
     * @param redisson
     */
    private static void testRedissonSimpleTryLock(RedissonClient redisson) {
        // 获取key为anyLock的锁对象
        RLock rLock = redisson.getLock("anyTryLock");

        // 加锁时，设置尝试获取锁最多等待30s、上锁10s后自动解锁
        try {
            if (rLock.tryLock(30, 10, TimeUnit.SECONDS)) {
                try {
                    // TODO
                } catch (Exception e) {
                } finally {
                    // 解锁
                    rLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}













