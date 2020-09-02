package com.javaniuniu.juc.loop.output.subject15;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 3:58 PM
 */
public class Test_Condition {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for(char c:aI) {
                    System.out.print(c);
                    condition1.await();
                    condition2.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"T1").start();
        new Thread(()->{
            try {
                lock.lock();
                for(char c:aC) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"T2").start();
    }
}
