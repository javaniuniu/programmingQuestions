/**
 * 写一个固定容量的容器，拥有put和get方法，以及getCount 方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
package com.javaniuniu.juc.loop.output.subject10;

import java.util.*;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 5:19 PM
 */
public class T1_Container {
    final LinkedList linkedList = new LinkedList();
    final static int MAX = 10;
    private int count = 0;

    public synchronized void put(Object value) {
        while (linkedList.size()==MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "   添加了 " + value.hashCode());
        linkedList.add(value);
        ++count;
        this.notifyAll(); // 生产者和消费者都被同时唤醒
    }

    public synchronized Object get() {
        while (linkedList.size()==0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Object o = linkedList.removeFirst();
        count --;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "   拿到了 " + o.hashCode());
        return o;
    }

    public int getCount() {
        return linkedList.size();
    }

    public static void main(String[] args) {
        T1_Container container = new T1_Container();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    container.get();
                }
            }, "消费者线程：" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j <25 ; j++) {
                    container.put(new Object());
                }

            }, "生产者线程：" + i).start();
        }
    }
}
