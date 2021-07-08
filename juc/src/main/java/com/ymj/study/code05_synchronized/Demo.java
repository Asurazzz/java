package com.ymj.study.code05_synchronized;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2021/7/8 10:55
 * @Created by yemingjie
 */
public class Demo {
    private static int count = 0;
    public synchronized static void inc() {
        try {
            Thread.sleep(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> Demo.inc()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果: " + count);
    }
}


