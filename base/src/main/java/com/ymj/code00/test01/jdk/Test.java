package com.ymj.code00.test01.jdk;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 9:49
 */
public class Test {
    public static void main(String[] args) {
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        proxy.add(1, 1);
        System.out.println(proxy.getClass());
    }
}
