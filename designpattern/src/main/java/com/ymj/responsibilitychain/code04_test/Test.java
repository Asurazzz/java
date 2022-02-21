package com.ymj.responsibilitychain.code04_test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:27.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        //1、装配通知
        List<MethodInterceptor> list = new ArrayList();
        list.add(new BeforeMethodInterceptor());
        list.add(new AfterMethodInterceptor());
        list.add(new AroundMethodInterceptor());
        //2、创建目标方法；
        TestService testService = new TestService();
        Method test = TestService.class.getMethod("test", String.class);
        Object[] params = {"Hello World!"};
        new DefaultMethodInvocation(list, testService, test, params).proceed();
    }
}
