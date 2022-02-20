package com.ymj.responsibilitychain.code03_test;

/**
 * 连接点接口
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:12.
 */
public interface JoinPoint {
    Object proceed() throws Throwable;
}
