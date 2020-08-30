/**
 * 3. 问题描述
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75. 程序的输出结果应该为:
 * <p>
 * 线程1: 1
 * 线程1: 2
 * 线程1: 3
 * 线程1: 4
 * 线程1: 5
 * <p>
 * 线程2: 6
 * 线程2: 7
 * 线程2: 8
 * 线程2: 9
 * 线程2: 10
 * …
 * <p>
 * 线程3: 71
 * 线程3: 72
 * 线程3: 73
 * 线程3: 74
 * 线程3: 75
 */

package com.javaniuniu.juc.loop.output.subject3;

/**
 * @auther: javaniuniu
 * @date: 2020/8/29 4:02 PM
 */
// 使用内置锁 给 class 上锁
public class T1 implements Runnable {
    private static volatile int count = 0;
    // 必须要使用static 修饰，来保证变量为整个class所有
    // 如果 不使用 static 修饰， 每次 new T2() count都会初始化为 0
    // volatile 保证数据的唯一性

    private int threadId;
    private Object o;

    public T1(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (count < 75) {
            synchronized (T1.class) {
                if (count / 5 % 3 + 1 == threadId) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程" + threadId + " : " + ++count);
                    }
                    T1.class.notifyAll();
                } else {
                    try {
                        T1.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new T1(1)).start();
        new Thread(new T1(2)).start();
        new Thread(new T1(3)).start();
    }
}
