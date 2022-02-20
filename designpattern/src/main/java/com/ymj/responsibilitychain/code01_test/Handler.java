package com.ymj.responsibilitychain.code01_test;

/**
 * 抽象处理者角色
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 16:38.
 */
public abstract class Handler {
    private Handler next;

    /**
     * 处理请求方法
     * @param request
     */
    public abstract void handleRequest(String request);


    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}
