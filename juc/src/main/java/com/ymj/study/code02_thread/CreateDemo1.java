package com.ymj.study.code02_thread;

/**
 * @author : yemingjie
 * @date : 2021/7/4 12:20
 */
public class CreateDemo1 {
    public static void main(String[] args) {

        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        //创建一个新线程
        ThreadDemo1 thread1 = new ThreadDemo1();
        //为线程设置名称
        thread1.setName("线程一");
        //开启线程
        thread1.start();
    }
}

class ThreadDemo1 extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
    }

}
