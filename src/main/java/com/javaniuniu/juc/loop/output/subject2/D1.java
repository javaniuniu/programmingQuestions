/**
 * 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z；
 */
package com.javaniuniu.juc.loop.output.subject2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: javaniuniu
 * @date: 2020/8/29 11:16 AM
 */
public class D1 {
    private int fist_num = 1;
    private int fist_char = 65;
    private volatile StringBuffer ans = new StringBuffer();
    private volatile boolean flag = true; // 等待状态

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void printNum() {
        String before = null;
        String after = null;
        try {
            lock.lock();
            while (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            before = String.valueOf(fist_num);
            after = String.valueOf(fist_num + 1);
            fist_num = fist_num + 2;
            ans.append(before);
            ans.append(after);

            flag = false;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printChar() {
        String str_char = null;
        try {
            lock.lock();
            while (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            str_char = String.valueOf((char) fist_char);
            fist_char++;
            ans.append(str_char);

            flag = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        D1 d1 = new D1();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                d1.printNum();
            }
        }, "printNum").start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                d1.printChar();
                System.out.println(d1.ans);
            }
        }, "printChar").start();


    }

}
