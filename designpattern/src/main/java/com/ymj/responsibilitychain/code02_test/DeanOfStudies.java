package com.ymj.responsibilitychain.code02_test;

/**
 * 具体处理者4：教务处长类
 * @author yemingjie.
 * @date 2022/2/20.
 * @time 17:03.
 */
public class DeanOfStudies extends Leader{
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 20) {
            System.out.println("教务处长批准您请假" + leaveDays + "天。");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
