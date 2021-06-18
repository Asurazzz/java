package com.ymj.code05_stream;

import com.ymj.code04_lambda.lambda02.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname StreamTestSort
 * @Description
 *  sorted()：自然排序
 *  sorted(Comparator com)：定制排序
 * @Date 2021/6/18 11:48
 * @Created by yemingjie
 */
public class StreamTestSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        // 自然排序，按照字典进行排序
        list.stream().sorted().forEach(System.out::println);


        System.out.println("===============================");
        // 定制排序
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 16, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );

        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).forEach(System.out::println);
        
    }
}
