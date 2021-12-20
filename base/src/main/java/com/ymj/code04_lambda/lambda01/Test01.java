package com.ymj.code04_lambda.lambda01;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Classname Test01
 * @Description TODO
 * @Date 2021/6/11 10:02
 * @Created by yemingjie
 */
public class Test01 {
    /**
     * 原来使用匿名内部类
     */
    public static void test() {
        // 使用匿名内部类，重写Intger的 compare方法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // 传入比较的方法
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    /**
     * 使用Lambda表达式解决匿名内部类需要编写大量模板语言的问题
     */
    public static void testWithLambda() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);

        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }
}


















