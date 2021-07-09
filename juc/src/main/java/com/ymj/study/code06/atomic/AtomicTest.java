package com.ymj.study.code06.atomic;

import com.ymj.study.util.Print;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicTest
 * @Description TODO
 * @Date 2021/7/9 15:25
 * @Created by yemingjie
 */
public class AtomicTest {

    public static void main(String[] args) {
        int tempValue = 0;
        // 定义一个整数原子类实例，赋值到变量 i
        AtomicInteger i = new AtomicInteger(0);

        // 取值，然后设置一个新值
        tempValue = i.getAndSet(3);
        // 输出 tempValue：0； i: 3
        System.out.println("tempValue: " + tempValue + "; i : " + i.get());

        // 取值，然后自增
        tempValue = i.getAndIncrement();
        // 输出 tempValue：3； i: 4
        System.out.println("tempValue: " + tempValue + "; i : " + i.get());

        // 取值，然后增加5
        tempValue = i.getAndAdd(5);
        //输出 tempvalue:4; i:9
        System.out.println("tempValue: " + tempValue + "; i : " + i.get());

        //CAS 交换
        boolean flag = i.compareAndSet(9, 100);
        //输出 flag:true; i:100
        System.out.println("flag:" + flag + "; i:" + i.get());
    }
}

