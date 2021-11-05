//package com.ymj.jvm02.oom;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * -Xms10m -Xmx10m
// */
//public class TestHeap {
//    public static void main(String[] args) {
//        long counter = 0;
//        List<Object> list = new ArrayList<>();
//        while (true) {
//            list.add(new Object());
//            System.out.println("当前创建了第" + (counter) + "个对象");
//        }
//    }
//}
