package com.ymj.study.code02_thread;

/**
 * @author : yemingjie
 * @date : 2021/7/4 9:36
 */
public class CreateDemo {
    public static final int MAX_TURN = 5;
    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    // 线程编号
    static int threadNo = 1;

    static class DemoThread extends Thread {
        public DemoThread() {
            super("DemoThread-" + threadNo++);
        }

        @Override
        public void run() {
            for (int i = 1; i < MAX_TURN; i++) {
                System.out.println(getName() + ", 轮次：" + i);
            }
            System.out.println(getName() + " 运行结束.");
        }
    }

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }
        System.out.println(getCurThreadName() + " 运行结束.");
    }
}
