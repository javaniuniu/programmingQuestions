package com.javaniuniu.juc.loop.output.subject16;

import java.util.concurrent.*;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 6:32 PM
 */
// Callable = Runable + return
//
public class Test_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> "hello Callable";

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);

        System.out.println(future.get());// 阻塞线程

        service.shutdown();//线程使用完后关闭

    }
}
