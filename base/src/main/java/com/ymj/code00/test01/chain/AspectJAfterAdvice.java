package com.ymj.code00.test01.chain;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 17:59
 */
public class AspectJAfterAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object var = null;
        try {
            var = mi.proceed();
        } finally {
            System.out.println("执行了后置方法！");
        }
        return var;
    }
}
