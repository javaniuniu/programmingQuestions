/**
 * 写一个固定容量的容器，拥有put和get方法，以及getCount 方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
package com.javaniuniu.juc.loop.output.subject10;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 5:19 PM
 */
public class T2_Container {
    final LinkedList linkedList = new LinkedList();
    final static int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(Object value) {
        try {
            lock.lock();
            while (linkedList.size() == MAX) { //想想为什么用while而不是用if？
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "   添加了 " + value.hashCode());
            linkedList.add(value);
            ++count;
            consumer.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        try {
            lock.lock();
            while (linkedList.size() == 0) {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Object o = linkedList.removeFirst();
            count--;
            producer.signalAll();
            System.out.println(Thread.currentThread().getName() + "   拿到了 " + o.hashCode());
            return o;
        } finally {
            lock.unlock();
        }

    }

    public int getCount() {
        return linkedList.size();
    }

    public static void main(String[] args) {
        T2_Container container = new T2_Container();

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
                for (int j = 0; j < 25; j++) {
                    container.put(new Object());
                }
            }, "生产者线程：" + i).start();
        }
    }
}
