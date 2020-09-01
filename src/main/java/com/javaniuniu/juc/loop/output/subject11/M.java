package com.javaniuniu.juc.loop.output.subject11;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 4:15 PM
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
