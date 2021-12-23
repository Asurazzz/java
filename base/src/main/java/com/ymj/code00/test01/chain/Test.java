package com.ymj.code00.test01.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 18:03
 */
public class Test {

    /**
     * 前置增强拦截器（对应下标为0）
     * 后置增强拦截器（对应下标为1）
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        List<MethodInterceptor> lists = new ArrayList<>();
        // 后置增强
        AspectJAfterAdvice aspectJAfterAdvice = new AspectJAfterAdvice();
        // 前置增强
        BeforeMethodInterceptor beforeMethodInterceptor = new BeforeMethodInterceptor();

        lists.add(beforeMethodInterceptor);
        lists.add(aspectJAfterAdvice);


        ReflectiveMethodInvocation reflectiveMethodInvocation
                = new ReflectiveMethodInvocation(lists);
        reflectiveMethodInvocation.proceed();
    }
}
