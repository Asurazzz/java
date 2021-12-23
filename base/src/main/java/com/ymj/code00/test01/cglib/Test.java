package com.ymj.code00.test01.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 9:55
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyCalculator.class);
        enhancer.setCallback(new MyCglib());
        MyCalculator myCalculatorCglib = (MyCalculator) enhancer.create();
        int add = myCalculatorCglib.add(1, 1);
        System.out.println(add);
        System.out.println(myCalculatorCglib.getClass());
    }
}
