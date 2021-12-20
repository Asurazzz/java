package com.ymj.code05_stream;

import com.ymj.code04_lambda.lambda02.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname StreamTestPause
 * @Description
 *  执行下列操作后，Stream流就会进行终止执行
 *
 * 查找与匹配
 *
 * allMatch：检查是否匹配所有元素
 * anyMatch：检查是否至少匹配一个元素
 * noneMatch：检查是否一个都没匹配
 * findFirst：返回第一个元素
 * findAny：返回当前流中任意一个元素
 * count：返回流中元素的个数
 * max：返回当前流中最大值
 * min：返回当前流中最小值
 * forEach：内部迭代
 * @Date 2021/6/18 11:55
 * @Created by yemingjie
 */
public class StreamTestPause {
    public static void main(String[] args) {
        // 定制排序
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );
        Boolean isAllMatch = employees.stream().allMatch((x) -> x.getAge() > 7);
        System.out.println("是否匹配所有元素:" + isAllMatch);

        Boolean isAnyMatch = employees.stream().anyMatch((x) -> x.getAge() > 90);
        System.out.println("是否匹配至少一个元素:" + isAnyMatch);

    }
}
