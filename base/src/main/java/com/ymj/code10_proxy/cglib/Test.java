package com.ymj.code10_proxy.cglib;


import net.sf.cglib.proxy.Enhancer;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/22 11:49
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(MyCalculator.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new MyCglib());
        //创建代理对象
        MyCalculator myCalculator = (MyCalculator) enhancer.create();
        //通过代理对象调用目标方法
        myCalculator.add(1,1);
        System.out.println(myCalculator.getClass());
    }
}
