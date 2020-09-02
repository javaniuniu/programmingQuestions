package com.javaniuniu.juc.loop.output.subject13;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 8:30 PM
 */
// 线程不安全 会多卖的问题
public class Test_TicketSell_list {
    static List<String> tickets = new ArrayList<>();
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
                    System.out.println("销售了： "+tickets.remove(0));
                }
            }).start();
        }
    }

}
