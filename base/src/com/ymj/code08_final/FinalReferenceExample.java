package com.ymj.code08_final;

/**
 * @Classname FinalReferenceExample
 * @Description TODO
 * @Date 2021/6/24 17:40
 * @Created by yemingjie
 */
public class FinalReferenceExample {
    // final是引用类型
    final int[] intArray;
    static FinalReferenceExample obj;

    // 构造函数
    public FinalReferenceExample() {
        // 1
        intArray = new int[1];
        // 2
        intArray[0] = 1;
    }

    // 写程序A执行
    public static void writerOne() {
        // 3
        obj = new FinalReferenceExample();
    }

    // 写程序B执行
    public static void writerTwo() {
        // 4
        obj.intArray[0] = 2;
    }

    // 读程序C执行
    public static void reader() {
        // 5
        if (obj != null) {
            // 6
            int temp1 = obj.intArray[0];
        }
    }
}
