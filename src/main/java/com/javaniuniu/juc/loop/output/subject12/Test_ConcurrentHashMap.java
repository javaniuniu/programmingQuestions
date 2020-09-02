package com.javaniuniu.juc.loop.output.subject12;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 8:02 PM
 */
public class Test_ConcurrentHashMap {
    static Map<UUID, UUID> map = new ConcurrentHashMap<>();

    static int count = Constants.COUNT;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];

    static final int THREAD_COUNT = Constants.THREAD_COUNT;

    // 初始化测试数据
    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start; // 在UUID数组中，插入1w个数据的开始值
        int gap = count / THREAD_COUNT; // 每个线程处理数据个数

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < start + gap; i++) {
                map.put(keys[i], values[i]);
            }
        }
    }

    public static void main(String[] args) {

        //-------测试写操作--------
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * (count / THREAD_COUNT));
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());

        //----------测试读操作------

        start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    map.get(keys[10]); // 对 keys[10] 读100000000次
                }
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
