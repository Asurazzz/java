package com.ymj.responsibilitychain.code03_test;

import java.util.List;

/**
 * 中间类，用于处理一个接一个的拦截器
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:27.
 */
public class ReflectiveMethodInvocation implements MethodInvocation{

    private int index = -1;

    List<MethodInterceptor> methodInterceptors;

    public ReflectiveMethodInvocation(List<MethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
    }

    @Override
    public Object proceed() throws Throwable {
        Object var = null;
        if (index == this.methodInterceptors.size() - 1) {
            System.out.println("调用被代理的原本方法");
        } else {
            methodInterceptors.get(++index).invoke(this);
        }
        return var;
    }
}
