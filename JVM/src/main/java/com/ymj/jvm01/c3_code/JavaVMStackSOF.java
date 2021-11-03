package com.ymj.jvm01.c3_code;

/**
 * @Classname JavaVMStackSOF
 * @Description TODO
 * @Date 2021/8/12 16:47
 * @Created by yemingjie
 */
public class JavaVMStackSOF {
    // 启动是添加VM Args： -Xss128k

    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable ex) {
            System.out.println("stack length:" + oom.stackLength);
            throw ex;
        }
    }
}
