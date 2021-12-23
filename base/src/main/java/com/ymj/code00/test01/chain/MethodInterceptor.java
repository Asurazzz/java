package com.ymj.code00.test01.chain;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 17:57
 */
public interface MethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
