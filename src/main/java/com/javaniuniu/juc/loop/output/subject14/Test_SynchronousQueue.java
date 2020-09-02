package com.javaniuniu.juc.loop.output.subject14;

import java.util.concurrent.SynchronousQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:40 AM
 */

// 这里只能用 put 方法 ，只能put一次 ，也不能使用 add 方法
// SynchronousQueue 没有容量，在put之后进入阻塞状态， 需要把数据tack出去
public class Test_SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue strs = new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaaa");;
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }
}
