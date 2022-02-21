package com.ymj.responsibilitychain.code04_test;

/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:16.
 */
public class AfterMethodInterceptor implements MethodInterceptor{
    @Override
    public void invoke(MethodInvocation methodInvocation) {
        methodInvocation.proceed();
        System.out.println("【后置通知】");
    }
}
