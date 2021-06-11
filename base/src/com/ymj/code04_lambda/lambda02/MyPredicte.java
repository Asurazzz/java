package com.ymj.code04_lambda.lambda02;

/**
 * @Classname MyPredicte
 * @Description 2.然后创建一个接口，这里就是判定条件
 * @Date 2021/6/11 10:15
 * @Created by yemingjie
 */
public interface MyPredicte<T> {
    public boolean test(T t);
}
