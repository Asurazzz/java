package com.ymj.code00.test01.jdk;

import java.lang.reflect.Proxy;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 9:50
 */
public class CalculatorProxy {

    public static Calculator getProxy(final Calculator calculator) {
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                ((proxy, method, args) -> {
                    Object result = null;
                    try {
                        result = method.invoke(calculator, args);
                    } catch (Exception ex) {

                    } finally {

                    }
                    return result;
                }));
        return o;
    }
}
