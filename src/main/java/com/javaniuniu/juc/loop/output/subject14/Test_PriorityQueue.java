package com.javaniuniu.juc.loop.output.subject14;

import java.util.PriorityQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:41 AM
 */
// 数据按照一定顺序输出，默认又小到大输出，也可以自定义比较输出顺序
public class Test_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
