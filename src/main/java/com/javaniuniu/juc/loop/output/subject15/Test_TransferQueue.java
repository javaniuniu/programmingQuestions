package com.javaniuniu.juc.loop.output.subject15;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 10:59 AM
 */
public class Test_TransferQueue {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        TransferQueue<Character> transferQueue = new LinkedTransferQueue<>();
        new Thread(()->{
            for(char c:aI) {
                try {
                    transferQueue.transfer(c);
                    System.out.print(transferQueue.take());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();

        new Thread(()->{
            for(char c:aC) {
                try {
                    System.out.print(transferQueue.take());
                    transferQueue.transfer(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();


    }
}
