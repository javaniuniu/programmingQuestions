/**
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1 添加10个元素到容器，线程2 实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 */
package com.javaniuniu.juc.loop.output.subject9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 5:17 PM
 */
public class T1_CountDownLatch {
    volatile List<Object> lists = new ArrayList();

    //    volatile List<Object> lists = Collections.synchronizedList(new LinkedList<>());
    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T1_CountDownLatch t = new T1_CountDownLatch();
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("T2启动了");
            if (t.size() != 5) {
                try {
                    latch1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch2.countDown();
            System.out.println("T2 结束了");


        }, "T2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add:" + i);
                if (t.size() == 5) {
                    latch1.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        }, "T1").start();


    }
}
