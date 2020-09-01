package com.javaniuniu.juc.loop.output.subject8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 1:30 PM
 */
// 允许一组线程全部等待彼此达到共同屏障点的同步辅助
public class Test_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10,()-> System.out.println("满了，发车"));
        Thread[] threads = new Thread[100];
        for(Thread thread:threads) {

        }

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
