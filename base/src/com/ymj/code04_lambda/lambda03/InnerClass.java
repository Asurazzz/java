package com.ymj.code04_lambda.lambda03;

import com.ymj.code04_lambda.lambda02.Employee;
import com.ymj.code04_lambda.lambda02.MyPredicte;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname InnerClass
 * @Description TODO
 * @Date 2021/6/11 10:40
 * @Created by yemingjie
 */
public class InnerClass {
    public static void main(String[] args) {
        test7();
    }

    /**
     * 不使用策略模式
     */
    public static void test7() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );
        employees.stream().filter(e-> e.getSalary() >= 5000).limit(3).forEach(System.out::println);

        System.out.println("=========");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
