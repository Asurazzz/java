package com.ymj.study.code04_volatile;

/**
 * @Classname VolatileDemo
 * @Description TODO
 * @Date 2021/7/7 11:22
 * @Created by yemingjie
 */
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        test.start();
        for (;;) {
            if (test.isFlag()) {
                System.out.println("hi");
            }
        }
    }
}
class VolatileTest extends Thread {
    private /*volatile*/ boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}
