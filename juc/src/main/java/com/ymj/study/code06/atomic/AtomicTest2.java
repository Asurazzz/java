package com.ymj.study.code06.atomic;

import com.ymj.study.util.Print;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Classname AtomicTest2
 * @Description TODO
 * @Date 2021/7/9 15:32
 * @Created by yemingjie
 */
public class AtomicTest2 {
    public static void main(String[] args) {
        int tempvalue = 0;
        //原始的数组
        int[] array = { 1, 2, 3, 4, 5, 6 };
        //包装为原子数组
        AtomicIntegerArray i = new AtomicIntegerArray(array);
        //获取第 0 个元素，然后设置为 2
        tempvalue = i.getAndSet(0, 2);
        //输出 tempvalue:1; i:[2, 2, 3, 4, 5, 6]
        System.out.println("tempvalue:" + tempvalue + "; i:" + i);
        //获取第 0 个元素，然后自增
        tempvalue = i.getAndIncrement(0);
        //输出 tempvalue:2; i:[3, 2, 3, 4, 5, 6]
        System.out.println("tempvalue:" + tempvalue + "; i:" + i);
        //获取第 0 个元素，然后增加一个 delta 5
        tempvalue = i.getAndAdd(0, 5);
        //输出 tempvalue:3; i:[8, 2, 3, 4, 5, 6]
        System.out.println("tempvalue:" + tempvalue + "; i:" + i);
    }
}
