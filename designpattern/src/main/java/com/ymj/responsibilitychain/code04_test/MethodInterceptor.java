package com.ymj.responsibilitychain.code04_test;


/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:12.
 */
public interface MethodInterceptor {

    /**
     * 定义共同通知的骨架
     * @param methodInvocation
     */
    void invoke(MethodInvocation methodInvocation);
}
