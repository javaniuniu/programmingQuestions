package com.javaniuniu.juc.loop.output.subject8;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 12:00 PM
 */
// 读写锁
public class Test_ReadWriteLock {
    static Lock lock = new ReentrantLock();
    private static int value;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static  void read(Lock lock) {
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock,int v) {
        try{
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println(Thread.currentThread().getName()+"writer over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Test_ReadWriteLock readWriteLock = new Test_ReadWriteLock();
        //Runnable readR = ()-> read(lock);
        Runnable readR = ()-> read(readLock);

        //Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR = ()->write(writeLock, new Random().nextInt());

        for(int i=0; i<18; i++) new Thread(readR).start();
        for(int i=0; i<2; i++) new Thread(writeR).start();
    }

}
