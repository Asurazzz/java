package com.ymj.code04_lambda.lambda04;

import com.ymj.code04_lambda.lambda02.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Classname LambdaTest
 * @Description
 * 左侧：Lambda表达式的参数列表（可以想象成，是上面定义的接口中抽象方法参数的列表）
 * 右侧：Lambda表达式中，所需要执行的功能，即Lambda体（需要对抽象方法实现的功能）
 * @Date 2021/6/11 10:49
 * @Created by yemingjie
 */
public class LambdaTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        new Thread(r).start();

        System.out.println("=========");

        new Thread(() -> System.out.println("hello lambda")).start();

    }

    /**
     * 2.有一个参数，有返回值
     * (x) -> System.out.println(x);
     * 或  (一个参数时，小括号可以省略不写)
     * x -> System.out.println(x);
     */
    public static void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("我在bilibili");
    }


    /**
     * 3.多个参数，有返回值
     */
    public static void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 4、有多个参数，只有一条语句
     * 这个时候，可以省略大括号 和 return
     */
    public static void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    public static void test5() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 3333),
                new Employee("李四", 38, 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );
        Collections.sort(employees, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
