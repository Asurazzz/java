package com.ymj.code00.test01.chain;

import java.util.List;

/**
 * 一个中间类，用于处理一个接一个的拦截器
 * @author admin
 * @version 1.0
 * @date 2021/12/23 18:00
 */
public class ReflectiveMethodInvocation implements MethodInvocation{

    List<MethodInterceptor> methodInterceptors;

    public ReflectiveMethodInvocation(List<MethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
    }
    private int index = -1;


    @Override
    public Object proceed() throws Throwable {
        Object var = null;
        if (index == this.methodInterceptors.size() - 1) {
            System.out.println("调用被代理的原本方法！");
        } else {
            MethodInterceptor methodInterceptor = methodInterceptors.get(++index);
            methodInterceptor.invoke(this);
        }

        return var;
    }
}
