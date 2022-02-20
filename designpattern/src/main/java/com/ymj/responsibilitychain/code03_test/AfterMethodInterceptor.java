package com.ymj.responsibilitychain.code03_test;

/**
 * 后置增强
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:26.
 */
public class AfterMethodInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object var = null;
        try {
            var = mi.proceed();
        } finally {
            System.out.println("执行了后置方法");
        }
        return var;
    }
}
