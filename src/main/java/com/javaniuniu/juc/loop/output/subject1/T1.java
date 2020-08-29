/**
 * 题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次；
 */
package com.javaniuniu.juc.loop.output.subject1;
/**
 * @auther: javaniuniu
 * @date: 2020/8/28 11:34 PM
 */
// 内置锁
public class T1 {
    private static volatile boolean flag = true; // 等待状态

    public synchronized void main_thread() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for(int i=0;i<2;i++) {
            System.out.println(Thread.currentThread().getName()+" run-----" + i);
        }
        flag =true;
        this.notify();
    }
    public synchronized void sub_thread() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<2;i++) {
            System.out.println(Thread.currentThread().getName()+" run" +i );
        }
        flag =false;
        this.notify();
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t1.sub_thread();
                }
            }
        },"sub").start();

        for (int i = 0; i < 10; i++) {
            t1.main_thread();
        }


    }
}
