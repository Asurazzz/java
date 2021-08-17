package com.ymj.jvm01.c7_code;

/**
 * @author : yemingjie
 * @date : 2021/8/17 22:37
 */
public class Demo2_jinfo {
    public static void main(String[] args) {
        System.out.println("jinfo 指令");

        try {
            Thread.sleep(2000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
