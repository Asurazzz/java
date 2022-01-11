package com.ymj.code00.test03;

/**
 * @author admin
 * @version 1.0
 * @date 2022/1/4 18:04
 */
public class LeeMain {
    static int count = 0;
    static LeeLock lock = new LeeLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10000; i++) {
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
        System.out.println(count);
    }
}
