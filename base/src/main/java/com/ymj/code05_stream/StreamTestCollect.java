package com.ymj.code05_stream;

import com.ymj.code04_lambda.lambda02.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname StreamTestCollect
 * @Description
 * Collection将流转换成其它形式，接收一个Collector接口实现，用于给Stream中元素做汇总的方法
 *
 * 格式：collect(Collector c)
 *
 * Collector接口实现方法的实现决定了如何对流执行收集操作（如收集到List，Set，Map）。
 * 但是Collectors实用类提供了很多静态方法，可以方便地创建常用收集器实例
 * @Date 2021/6/18 11:58
 * @Created by yemingjie
 */
public class StreamTestCollect {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );
        // 收集放入list中
        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
