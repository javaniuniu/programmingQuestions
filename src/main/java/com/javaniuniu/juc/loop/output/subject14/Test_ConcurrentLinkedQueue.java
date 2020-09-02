package com.javaniuniu.juc.loop.output.subject14;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:41 AM
 */
// add()  添加不了抛出异常
// offer 能不能呢添加会有一个boolean的返回值
// poll() 取 会remove
// peek() 取 不会remove

public class Test_ConcurrentLinkedQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for(int i=0; i<10; i++) {
            strs.offer("a" + i);  //add

        }

        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());// 取 会remove
        System.out.println(strs.size());

        System.out.println(strs.peek()); // 取 不会remove
        System.out.println(strs.size());

        //双端队列Deque
    }
}
