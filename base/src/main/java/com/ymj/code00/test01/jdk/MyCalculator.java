package com.ymj.code00.test01.jdk;


/**
 * @author admin
 * @version 1.0
 * @date 2021/12/22 11:25
 */
public class MyCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mult(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
