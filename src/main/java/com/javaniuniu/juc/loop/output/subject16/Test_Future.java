package com.javaniuniu.juc.loop.output.subject16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 6:51 PM
 */
public class Test_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(1);
            return 123;
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get()); // 阻塞线程
    }
}
