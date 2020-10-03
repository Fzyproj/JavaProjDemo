package com.lucfzy.leetcode;

import java.util.concurrent.TimeUnit;

public class MyAQSTest {
    private static final MyAQS lock = new MyAQS();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        // 子线程运行count方法
        new Thread(() -> {
            try {
                count();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 主线程运行count方法
        count();
    }

    public static void count() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":::"+count);
                count++;
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
