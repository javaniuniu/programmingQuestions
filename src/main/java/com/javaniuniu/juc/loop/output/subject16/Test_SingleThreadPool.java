package com.javaniuniu.juc.loop.output.subject16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 11:24 PM
 */
public class Test_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++) {
            final int j = i;
            service.execute(()->{

                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
    }
}
