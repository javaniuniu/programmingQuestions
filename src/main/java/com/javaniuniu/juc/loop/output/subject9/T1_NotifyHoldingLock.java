/**
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1 添加10个元素到容器，线程2 实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 */
package com.javaniuniu.juc.loop.output.subject9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 5:17 PM
 */
public class T1_NotifyHoldingLock {
    volatile List<Object> lists = new ArrayList();
//    volatile List<Object> lists = Collections.synchronizedList(new LinkedList<>());
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T1_NotifyHoldingLock t = new T1_NotifyHoldingLock();
        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock) {
                System.out.println("T2启动了");
                if(t.size()!=5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2 结束了");
            }


        },"T2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add:" + i);
                    if (t.size() == 5) {
                        lock.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"T1").start();


    }
}
