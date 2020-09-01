package com.javaniuniu.juc.loop.output.subject8;

import java.util.concurrent.Semaphore;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 2:03 PM
 */
public class Test_Semaphore {

    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore(1);
        //运行两个个线程同时执行
        Semaphore semaphore = new Semaphore(2);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T1 running...");
                Thread.sleep(1000);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        },"T1").start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T2 running...");
                Thread.sleep(1000);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        },"T2").start();

    }
}
