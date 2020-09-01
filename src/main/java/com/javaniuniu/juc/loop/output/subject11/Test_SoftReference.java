package com.javaniuniu.juc.loop.output.subject11;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 4:17 PM
 */
// -Xms20M Xmx20M
public class Test_SoftReference {


    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
//        m = null;
        System.out.println(m.get());
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        byte[] bytes = new byte[1024*1024*15];
        System.out.println(m.get());

    }

}
