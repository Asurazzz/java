package com.ymj.study.code02_thread;

/**
 * @author : yemingjie
 * @date : 2021/7/4 12:33
 */
public class CreateDemo2WithLambda {

    public static final int MAX_TURN = 5;
    static int threadNo = 1;
    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread = null;
        //使用 Lambda 表达式形式创建和启动线程
        for (int i = 0; i < 2; i++) {
            //①Lambda 表达式
            thread = new Thread( ()-> {
                for (int j = 1; j < MAX_TURN; j++) {
                    System.out.println((getCurThreadName() + ", 轮次：" + j));
                }
                System.out.println((getCurThreadName() + " 运行结束."));
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        System.out.println((getCurThreadName() + " 运行结束."));
    }
}
