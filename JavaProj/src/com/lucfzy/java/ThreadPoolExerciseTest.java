package com.lucfzy.java;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ThreadPoolExerciseTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * Runnable构建任务，execute执行任务。
         */
//        // 构建一个最普通的线程池模型。使用ThreadPoolExecutor
//        Runnable runnable = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("线程池执行成功啦！！");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        // 构建执行器
//        ThreadFactory threadFactory = Thread::new;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                10,
//                20,
//                3,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(10));
//        // 执行任务
//        threadPoolExecutor.execute(runnable);
//        threadPoolExecutor.execute(runnable);
//        threadPoolExecutor.execute(runnable);
//        threadPoolExecutor.execute(runnable);
//
//        threadPoolExecutor.shutdown();
        /**
         * Callable构建任务，submit执行任务。
         */
//        // 构建执行器
//        ThreadFactory threadFactory = Thread::new;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                10,
//                20,
//                3,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(10));
//
//        Future<String> submitTask = threadPoolExecutor.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "success";
//        });
//        // 获取结果，真正执行的地方。
//        String s = submitTask.get();
//        System.out.println(s);
//        threadPoolExecutor.shutdown();
        /**
         * 使用CompletableFuture构建Task。并执行
         */
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "success";
//        });
//        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "success";
//        });
//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "success";
//        });
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("我运行啦。。。"));
//
////        // 如果执行成功回调该方法
////        completableFuture.thenAccept(s -> System.out.println("result:" + s));
////        // 如果使用上述该方法要保证的是，主线程的运行时间要比线程池的运行时间要长，否则当主线程关闭时，线程池会立刻被销毁。
////        Thread.sleep(2000);
//        // 常规获取结果的方法，阻塞式进行。
//        voidCompletableFuture.get();
//        String s = completableFuture.get();
//        String s1 = completableFuture.get();
//        String s2 = completableFuture.get();
//        // 由于是runnable接口实现的任务，所以该任务的执行不需要返回值。
//        System.out.println(s+s1+s2);
    }
}
