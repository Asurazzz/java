package com.ymj.study.code04_volatile;

/**
 * @Classname VolatileAtomic
 * @Description TODO
 * @Date 2021/7/7 15:22
 * @Created by yemingjie
 */
public class VolatileAtomic {

    public static void main(String[] args) {
        MyTest myTest= new MyTest();
        for(int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myTest.addNum();
                }
            }, String.valueOf(i)).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t number= "+myTest.num);
    }
}

class MyTest {

    public volatile int num = 0;
    public void addNum() {
        num++;
    }
}
