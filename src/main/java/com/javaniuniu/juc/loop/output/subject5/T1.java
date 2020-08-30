/**
 * 两个线程轮流打印数字，一直到100
 */
package com.javaniuniu.juc.loop.output.subject5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: javaniuniu
 * @date: 2020/8/29 7:26 PM
 */
// synchronized (T1.class) 给class上锁
// synchronized (this) 给对象上锁
public class T1 implements Runnable {
    private static volatile int num = 1;

    @Override
    public void run() {

        synchronized (T1.class) {
            while (num <= 100) {
                T1.class.notify();
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                if (num>=100){
                    return;
                }

                try {
                    T1.class.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new T1(), "线程1").start();
        new Thread(new T1(), "线程2").start();
    }
}
