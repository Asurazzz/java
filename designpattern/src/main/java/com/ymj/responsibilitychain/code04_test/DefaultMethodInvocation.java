package com.ymj.responsibilitychain.code04_test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author yemingjie.
 * @date 2022/2/21.
 * @time 15:18.
 */
public class DefaultMethodInvocation implements MethodInvocation{

    /**
     * 存放所有通知
     */
    private List<MethodInterceptor> list;
    /**
     * 目标对象
     */
    private Object target;
    /**
     * 目标方法
     */
    private Method method;
    /**
     * 目标参数
     */
    private Object args[];
    //最终使用反射机制去执行方法

    private int index = -1;

    public DefaultMethodInvocation(List<MethodInterceptor> list, Object target, Method method, Object[] args) {
        this.list = list;
        this.target = target;
        this.method = method;
        this.args = args;
    }



    @Override
    public void proceed() {
        if (index == list.size() - 1) {
            try {
                // 执行目标方法
                method.invoke(target, args);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("【出现异常】");
            }
        }
        MethodInterceptor methodInterceptor = list.get(++index);
        methodInterceptor.invoke(this);

    }
}
