package com.ymj.code04_lambda.lambda02;

/**
 * @Classname FilterEmployeeBySalary
 * @Description 4.当某一天需求变更了，变成需要查找金额大于60000的，那么只需要在编写一个实现类即可
 * @Date 2021/6/11 10:27
 * @Created by yemingjie
 */
public class FilterEmployeeBySalary implements MyPredicte<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 60000;
    }
}
