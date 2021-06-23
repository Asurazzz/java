package com.ymj.bfbcys.test04_reorder;

/**
 * @Classname ReorderExample
 * @Description
 * flag变量是个标记，用来标识变量a是否已被写入。这里假设有两个线程A和B，A首先执行 writer()方法，
 * 随后B线程接着执行reader()方法。线程B在执行操作4时，能否看到线程A在操作 1对共享变量a的写入呢？
 * 答案是：不一定能看到。 由于操作1和操作2没有数据依赖关系，编译器和处理器可以对这两个操作重排序；
 * 同样， 操作3和操作4没有数据依赖关系，编译器和处理器也可以对这两个操作重排序。
 * 让我们先来 看看，当操作1和操作2重排序时，可能会产生什么效果？
 * @Date 2021/6/23 10:29
 * @Created by yemingjie
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;
    public void writer() {
        a = 1;         // 1
        flag = true;   // 2
    }

    public void reader() {
        if (flag) {   // 3
            int i = a * a;  // 4
        }
    }
}
