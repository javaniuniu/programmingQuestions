package com.javaniuniu.juc.loop.output.subject16;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 6:39 PM
 */
public class Test_ThreadPool {

    static class Task implements Runnable {
        private int i;
        public Task(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "i=" + i +
                    '}';
        }

        @Override
        public void run() {
            try {
                System.in.read(); // 线程阻塞
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardOldestPolicy() // 替换最老的线程
                new ThreadPoolExecutor.DiscardPolicy()  // 丢弃，不做处理
//                new ThreadPoolExecutor.CallerRunsPolicy() // 由上一个线程执行
//                new ThreadPoolExecutor.AbortPolicy() // 抛出异常

        );

        for (int i = 0; i < 8; i++) {
            poolExecutor.execute(new Task(i));
        }
        System.out.println(poolExecutor.getQueue());

        poolExecutor.execute(new Task(100));

        System.out.println(poolExecutor.getQueue());

        poolExecutor.shutdown();
    }
}
