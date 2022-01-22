package com.ymj.code10_proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/22 11:26
 */
public class CalculatorProxy {

    public static Calculator getProxy(Calculator calculator) {

        Calculator c = (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(), ((proxy, method, args) -> {
                    Object result = null;
                    try {
                        result = method.invoke(calculator, args);
                    } catch (Exception ex) {

                    } finally {

                    }
                    return result;
                }));
        return c;
    }
}
