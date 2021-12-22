package com.ymj.code10_proxy.jdk;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/22 11:34
 */
public class Test {
    public static void main(String[] args) {
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        proxy.add(1, 1);
        System.out.println(proxy.getClass());
    }
}
