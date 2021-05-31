package com.ymj.test01_concurrency;

/**
 * @Classname ConcurrencyTest
 * @Description 下面的代码演示串行和并发执行并累加操作的时间，请分析：下面的代码并发执行一定比 串行执行快吗？
 * @Date 2021/5/31 14:00
 * @Created by yemingjie
 *
 *
 * 当并发执行累加操作不超过百万次时，速度会比串行执行累加操作要 慢。
 * 那么，为什么并发执行的速度会比串行慢呢？这是因为线程有创建和上下文切换的开销。
 */
public class ConcurrencyTest {
    private static final long count = 100001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        // 为什么使用lamda表达式速度会变慢
//        Thread thread = new Thread(() -> {
//            int a = 0;
//            for (long i = 0; i < count; i++) {
//                a += 5;
//            }
//        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time+"ms,b="+b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b+",a="+a);
    }
}
