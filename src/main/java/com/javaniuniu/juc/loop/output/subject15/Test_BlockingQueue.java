package com.javaniuniu.juc.loop.output.subject15;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 3:53 PM
 */
public class Test_BlockingQueue {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        BlockingQueue<String> bq1 = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> bq2 = new ArrayBlockingQueue<>(1);
        new Thread(()->{
            for(char c:aI) {
                try {
                    bq1.put("OK");
                    bq2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(c);
            }
        },"T1").start();
        new Thread(()->{
            for(char c:aC) {
                try {
                    bq1.take();
                    bq2.put("OK");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(c);
            }
        },"T2").start();
    }
}
