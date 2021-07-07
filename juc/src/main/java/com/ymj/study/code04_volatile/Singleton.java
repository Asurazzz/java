package com.ymj.study.code04_volatile;

/**
 * @Classname DoubleCheckTest
 * @Description TODO
 * @Date 2021/7/7 15:55
 * @Created by yemingjie
 */
public class Singleton {
    public volatile static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                // 若为空，才进行对象创建，防止对象重复创建
                if (singleton == null) {
                    // 使用volatile防止重排序造成的异常
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
