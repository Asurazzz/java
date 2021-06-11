package com.ymj.code04_lambda.lambda02;

/**
 * @Classname FilterEmployeeByAge
 * @Description 3.按照年龄过滤
 * @Date 2021/6/11 10:19
 * @Created by yemingjie
 */
public class FilterEmployeeByAge implements MyPredicte<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 35;
    }
}
