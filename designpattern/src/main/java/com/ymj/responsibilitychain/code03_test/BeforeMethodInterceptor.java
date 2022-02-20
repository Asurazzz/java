package com.ymj.responsibilitychain.code03_test;

/**
 * 前置增强
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:25.
 */
public class BeforeMethodInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("在这里调用前置方法");
        return mi.proceed();
    }
}
