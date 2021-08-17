package com.ymj.jvm01.c7_code;

/**
 * @author : yemingjie
 * @date : 2021/8/17 22:31
 */
public class Demo1_Jps {
    public static void main(String[] args) {
        System.out.println("jps 指令");
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
