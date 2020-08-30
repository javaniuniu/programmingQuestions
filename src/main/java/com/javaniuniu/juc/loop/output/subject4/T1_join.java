/**
 * 现在有T1、T2、T3三个线程，你怎样保证T1在T2执行完后执行，T3在T1执行完后执行？
 */

package com.javaniuniu.juc.loop.output.subject4;

/**
 * @auther: javaniuniu
 * @date: 2020/8/29 7:10 PM
 */

// 需要先调用start方法后调用join方法；t1线程调用join方法后就会先执行t1线程的方法
public class T1_join implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": run");
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new T1_join(),"t1");
        Thread t2 = new Thread(new T1_join(),"t2");
        Thread t3 = new Thread(new T1_join(),"t3");

        try {
            t2.start();
            t2.join();
            t1.start();
            t1.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
