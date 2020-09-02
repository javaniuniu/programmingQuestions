package com.javaniuniu.juc.loop.output.subject13;

import java.util.Vector;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 8:44 PM
 */
// 还是有问题 ，Vector 的size 和remove 是线程安全的，但是 线程里面的代码块不是线程安全的，达不到原子性操作
public class Test_TicketSell_vector2 {
    static Vector<String> tickets = new Vector<>();
    static int ticket_count = 1000;

    static {
        for (int i = 0; i < ticket_count; i++) {
            tickets.add("票号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;
                        System.out.println("销售了： " + tickets.remove(0));
                    }
                }

            }).start();
        }
    }
}
