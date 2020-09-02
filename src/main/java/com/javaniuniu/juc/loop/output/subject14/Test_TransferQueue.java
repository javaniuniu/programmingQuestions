package com.javaniuniu.juc.loop.output.subject14;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:40 AM
 */
// transfer() 是阻塞方法，需要 tack() 后才解除阻塞，所有需要先执行 tack() 方法
// 相对 SynchronousQueue 只能两个线程之间信息传递 ，TransferQueue 可以多个线程拿数据
// 相对 SynchronousQueue 容量为零， TransferQueue 可以在队列里面插入多条数据
public class Test_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue strs = new LinkedTransferQueue();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");
    }
}
