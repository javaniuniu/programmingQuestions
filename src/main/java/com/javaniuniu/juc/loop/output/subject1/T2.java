/**
 * 题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次；
 */

package com.javaniuniu.juc.loop.output.subject1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: javaniuniu
 * @date: 2020/8/29 8:52 AM
 */

// 显示锁
public class T2 {

    private volatile boolean flag = true; // 等待状态

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void sub_thread() {
        try {
            lock.lock();
            while (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " run" + i);
            }
            flag = false;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void main_thread() {
        try {
            lock.lock();
            while (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " run ------" + i);
            }
            flag = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        T2 t2 = new T2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t2.sub_thread();
                }
            }
        }, "sub").start();
        for (int i = 0; i < 10; i++) {
            t2.main_thread();
        }
    }


}
