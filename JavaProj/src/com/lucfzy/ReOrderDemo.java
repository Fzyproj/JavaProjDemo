package com.lucfzy;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如果在单个线程的情况下这个程序是没有问题的。
 * 但是在多个线程下我们要考虑，如何保证数据的准确性？
 */
public class ReOrderDemo {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(1);

     int a = 0;
     volatile static boolean flag = false;
     private static volatile ReOrderDemo INSTANCE = null;

    /**
     * 线程1执行该方法
     */
    public void write() {
        a = 1;
        flag = true;
        System.out.println("线程1打印了。。。");
    }

    /**
     * 线程2执行该方法
     */
    public void read() {
        if (flag) {
            int i = a*a;
        }
        System.out.println("线程2打印了。。。。");
    }

    public static ReOrderDemo run() {
        synchronized (ReOrderDemo.class) {
            if (INSTANCE==null) {
                return new ReOrderDemo();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                ReOrderDemo run = run();
                System.out.println(run);
            }).start();
        }
    }

    /**
     * 单独使用volatile变量，也可以实现顺序控制方法执行。
     */
    public static void realize3() {
        ReOrderDemo INSTANCE = new ReOrderDemo();
        new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE.write();
        }).start();
        new Thread(() -> {
            while (true) {
                if (flag) {
                    INSTANCE.read();
                    break;
                }
            }
        }).start();
    }

    /**
     * 使用自旋锁等待， 先进行write后进行read
     */
    public static void realize2() {
        ReOrderDemo INSTANCE = new ReOrderDemo();
        new Thread(()-> {
            INSTANCE.write();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ATOMIC_INTEGER.set(0);
        }).start();
        new Thread(() -> {
            for (;;) {
                if (ATOMIC_INTEGER.compareAndSet(0,1)) {
                    INSTANCE.read();
                    break;
                }
            }
        }).start();
    }

    public static void realize1(ReOrderDemo INSTANCE) {
        new Thread(()->{
//            for (;;) {
//                if (ATOMIC_INTEGER.compareAndSet(1,0)) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    INSTANCE.write();
//                    break;
//                }
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE.write();
        },"Thread-1").start();
        new Thread(()->{
//            for (;;) {
////                if (ATOMIC_INTEGER.compareAndSet(0,1)) {
////                    if (flag) {
////                        INSTANCE.read();
////                        break;
////                    }
////                    System.out.println("线程2在循环");
////                    break;
////                }
//
//            }

        },"Thread-2").start();
    }
}
