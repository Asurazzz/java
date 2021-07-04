package com.ymj.study.code02_thread;

/**
 * @author : yemingjie
 * @date : 2021/7/4 12:28
 */
public class CreateDemo2 {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        //创建一个新线程
        Thread thread2 = new Thread(new ThreadDemo2());
        //为线程设置名称
        thread2.setName("线程二");
        //开启线程
        thread2.start();
    }
}

class ThreadDemo2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
    }

}
