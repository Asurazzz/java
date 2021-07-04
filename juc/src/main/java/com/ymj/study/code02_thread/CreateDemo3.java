package com.ymj.study.code02_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author : yemingjie
 * @date : 2021/7/4 12:51
 */
public class CreateDemo3 {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        //创建FutureTask的对象
        FutureTask<String> task = new FutureTask<>(new ThreadDemo3());
        //创建Thread类的对象
        Thread thread3 = new Thread(task);
        thread3.setName("线程三");
        //开启线程
        thread3.start();
        //获取call()方法的返回值，即线程运行结束后的返回值
        String result = task.get();
        System.out.println(result);

    }
}

class ThreadDemo3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        return Thread.currentThread().getName()+":"+"返回的结果";
    }
}
