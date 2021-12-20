package com.ymj.code05_stream;

import com.ymj.code04_lambda.lambda02.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname StreamTest
 * @Description
 * filter(Predicate p)：接收Lambda，从流中排除某些元素
 * distinct()：筛选，通过流所生成的hashCode()和equals()去除重复元素
 * limit(long maxSize)：截断流，使其元素不超过给定数量
 * skip(long n)：跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流
 * @Date 2021/6/18 11:41
 * @Created by yemingjie
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3333),
            new Employee("李四", 38, 55555),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 77777.77),
            new Employee("田七", 8, 8888.88)
        );
        // 取出前五个年纪大于8的员工
        Stream<Employee> stream = employees.stream();
        stream.filter(x -> x.getAge() > 8)
                .limit(5)
                .forEach(System.out::println);
    }
}
