package com.ymj.code05_stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname StreamTestReduce
 * @Description
 *
 *  格式：reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
 *
 * 可以将流中元素反复结合，得到一个新值
 *
 * 这个reduce，其实有点类似于Hadoop中的mapReduce，先做map操作，然后做reduce操作
 * @Date 2021/6/18 11:57
 * @Created by yemingjie
 */
public class StreamTestReduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5 ,6 ,7 ,8 , 9, 10);
        // 按照下面的规则进行累加操作
        // reduce的规约，就是把前面定义的起始值，作为了x
        Integer num = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(num);
    }

}
