package com.ymj.code00.test01.chain;

/**
 * @author admin
 * @version 1.0
 * @date 2021/12/23 17:53
 * 连接点接口
 */
public interface JointPoint {
    Object proceed() throws Throwable;
}
