package com.javaniuniu.juc.loop.output.subject13;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 8:47 PM
 */
public class Test_TicketSell_ConcurrentLinkedQueue {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static int ticket_count = 1000;
    static {
        for (int i = 0; i < ticket_count; i++) {
            tickets.add("票号"+ i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0) {
                    String s = tickets.poll();
                    if (s==null) {
                        break;
                    }else {
                        System.out.println("销售了： "+tickets.poll());
                    }

                }
            }).start();
        }
    }

}
