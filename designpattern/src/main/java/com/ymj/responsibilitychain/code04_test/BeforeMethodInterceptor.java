package com.ymj.responsibilitychain.code04_test;


/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:13.
 */
public class BeforeMethodInterceptor implements MethodInterceptor{

    @Override
    public void invoke(MethodInvocation methodInvocation) {
        System.out.println("【前置通知】");
        methodInvocation.proceed();
    }
}
