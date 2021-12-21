package com.ymj.jvm01.c7_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JConsoleDemo
 * @Description TODO
 * @Date 2021/8/18 16:44
 * @Created by yemingjie
 */
public class JConsoleDemo {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        Thread.sleep(10000);
    }
}
