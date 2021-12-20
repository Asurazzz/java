package com.ymj.code04_lambda.lambda02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname EmployeeTest
 * @Description 策略设计模式
 * @Date 2021/6/11 10:20
 * @Created by yemingjie
 */
public class EmployeeTest {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );

        // 按照年龄过滤
        MyPredicte<Employee> mp = new FilterEmployeeByAge();
        List<Employee> emps = employees.stream().filter(employee -> mp.test(employee)).collect(Collectors.toList());
        emps.forEach(employee -> System.out.println(employee.getName()));


        System.out.println("=====================");

        // 按照薪资过滤
        MyPredicte<Employee> mpSalary = new FilterEmployeeBySalary();
        List<Employee> emp = employees.stream().filter(e -> mpSalary.test(e)).collect(Collectors.toList());
        emp.forEach(employee -> System.out.println(employee.getName() + "==>" + employee.getSalary()));

    }
}
