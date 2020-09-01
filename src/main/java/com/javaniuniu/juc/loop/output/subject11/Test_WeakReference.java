package com.javaniuniu.juc.loop.output.subject11;

import java.lang.ref.WeakReference;

/**
 * @auther: javaniuniu
 * @date: 2020/9/1 4:17 PM
 */
public class Test_WeakReference {
    public static void main(String[] args) {
        WeakReference weakReference = new WeakReference(new M());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
        ThreadLocal tl = new ThreadLocal();
        tl.set(new M());
        tl.remove();
    }
}
