package com.ymj.responsibilitychain.code04_test;

/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:17.
 */
public class AroundMethodInterceptor implements MethodInterceptor{
    @Override
    public void invoke(MethodInvocation methodInvocation) {
        System.out.println("【目标方法之前环绕通知】");
        //执行前置通知
        methodInvocation.proceed();
        System.out.println("【目标方法之后环绕通知】");
    }
}
