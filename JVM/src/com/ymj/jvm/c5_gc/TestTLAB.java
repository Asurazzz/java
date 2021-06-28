package com.ymj.jvm.c5_gc;

/**
 * @author : yemingjie
 * @date : 2021/6/28 8:22
 * 测试线程本地分配TLAB(Thread Local Allocation Buffer)
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
 * 去掉之后速度会变的很慢
 */
public class TestTLAB {
    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * 没有外部对象引用，所以没有逃逸
     * @param i
     */
    void alloc(int i ) {
        new User(i, "name" + i);
    }

    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
