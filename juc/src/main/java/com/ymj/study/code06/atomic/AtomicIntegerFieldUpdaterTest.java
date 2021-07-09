package com.ymj.study.code06.atomic;

import com.ymj.study.util.Print;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Classname AtomicIntegerFieldUpdaterTest
 * @Description TODO
 * @Date 2021/7/9 15:53
 * @Created by yemingjie
 */
public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        //使用静态方法 newUpdater( )创建一个更新器 updater
        AtomicIntegerFieldUpdater<User> updater=
                AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
        User user = new User("1", "张三");
        //使用属性更新器的 getAndIncrement、getAndAdd 增加 user 的 age 值
        System.out.println(updater.getAndIncrement(user));// 1
        System.out.println(updater.getAndAdd(user, 100));// 101
        //使用属性更新器的 get 获取 user 的 age 值
        System.out.println(updater.get(user));// 101
    }
}
