package com.ymj.responsibilitychain.code02_test;

/**
 * 抽象处理者：领导类
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 16:58.
 */
public abstract class Leader {
    private Leader next;


    /**
     * 处理请求的方法
     * @param leaveDays
     */
    public abstract void handleRequest(int leaveDays);

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }
}
