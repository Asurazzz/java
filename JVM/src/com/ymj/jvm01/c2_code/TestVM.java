package com.ymj.jvm01.c2_code;

/**
 * @Classname TestVM
 * @Description TODO
 * @Date 2021/8/12 11:02
 * @Created by yemingjie
 */
public class TestVM {
    public static void main(String[] args) {
//        byte[] b=new byte[5*1024*1024];
//        System.out.println("分配了1M空间给数组");
        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }
}
