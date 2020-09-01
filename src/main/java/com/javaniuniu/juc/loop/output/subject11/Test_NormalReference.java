package com.javaniuniu.juc.loop.output.subject11;

import java.io.IOException;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 4:16 PM
 */
public class Test_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
//        m = null; // 设置为空之后才会被回收
        System.gc();
        System.in.read();// 为了方便观察，阻塞住当前线程
    }
}
