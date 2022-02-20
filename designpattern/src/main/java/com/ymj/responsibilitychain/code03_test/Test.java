package com.ymj.responsibilitychain.code03_test;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:33.
 */
public class Test {
    public static void main(String[] args) throws Throwable{
        List<MethodInterceptor> lists = new ArrayList<>();
        // 后置增强
        AfterMethodInterceptor after = new AfterMethodInterceptor();
        // 前置增强
        BeforeMethodInterceptor before = new BeforeMethodInterceptor();
        lists.add(after);
        lists.add(before);
        ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation(lists);
        reflectiveMethodInvocation.proceed();
    }
}
