package com.ymj.responsibilitychain.code03_test;

/**
 * 方法拦截器接口
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:14.
 */
public interface MethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
