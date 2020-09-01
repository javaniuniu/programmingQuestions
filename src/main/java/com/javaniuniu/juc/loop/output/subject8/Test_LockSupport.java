package com.javaniuniu.juc.loop.output.subject8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 5:09 PM
 */
public class Test_LockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i ==5) {
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
//                    LockSupport.park();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已经睡了8妙。。。");
        LockSupport.unpark(t);
    }
}
