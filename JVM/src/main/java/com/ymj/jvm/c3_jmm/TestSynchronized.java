package com.ymj.jvm.c3_jmm;

/**
 * @author : yemingjie
 * @date : 2021/6/24 23:03
 */
public class TestSynchronized {
    synchronized void m() {

    }

    void n() {
        synchronized (this) {

        }
    }

}
