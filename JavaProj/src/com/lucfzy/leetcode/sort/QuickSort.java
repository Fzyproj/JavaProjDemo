package com.lucfzy.leetcode.sort;

public class QuickSort {
    private static final ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        stringThreadLocal.set("我叫付泽义");
        System.out.println(stringThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("我是大好人");
                System.out.println(stringThreadLocal.get());
            }
        }).start();
    }
}
