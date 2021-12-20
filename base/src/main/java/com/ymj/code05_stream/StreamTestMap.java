package com.ymj.code05_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @Classname StreamTestMap
 * @Description
 * map接收Lambda，将元素转换成其它形式或提取信息，接收一个函数作为参数，
 * 该函数会被应用到每个元素上，并将其映射成一个新元素。flatMap 接收一个函数作为参数，
 * 将流中的每个值都转换成另一个流，然后把所有流连接成一个流。
 * @Date 2021/6/18 11:46
 * @Created by yemingjie
 */
public class StreamTestMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
    }
}
