package com.javaniuniu.juc.loop.output.subject14;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:41 AM
 */
// 需要设置队列的固定大小
public class Test_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static Random r = new Random();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a"+i);
        }

//        strs.put("aaa"); //队列满了之后，在使用put方法，会进入阻塞状态，等待其他线程tack 数据
//        strs.add("aaa"); // 队列满了之后， 再插入数据会报错
//        strs.offer("aaa");// 队列满了之后，在插入数据，数据插不了

        strs.offer("aaa", 1, TimeUnit.SECONDS); // 可以设置超时时间

        System.out.println(strs);

    }
}
