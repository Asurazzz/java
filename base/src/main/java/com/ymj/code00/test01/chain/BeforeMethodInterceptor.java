package com.ymj.code00.test01.chain;

/**
 * 一个前置增强
 * @author admin
 * @version 1.0
 * @date 2021/12/23 17:58
 */
public class BeforeMethodInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("在这里调用前置方法");
        return mi.proceed();
    }
}
