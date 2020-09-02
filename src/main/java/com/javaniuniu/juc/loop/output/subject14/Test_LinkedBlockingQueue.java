package com.javaniuniu.juc.loop.output.subject14;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:41 AM
 */
// LinkedBlockingQueue 容量无界限，最大是 jvm内存大小
public class Test_LinkedBlockingQueue {
    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a"+i); // 线程满了，会进入等待状态
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();

        }

    }
}
