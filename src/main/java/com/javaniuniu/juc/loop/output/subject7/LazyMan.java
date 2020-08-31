package com.javaniuniu.juc.loop.output.subject7;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 9:33 AM
 */
public class LazyMan {

    private static LazyMan lazyMan = null;

    private LazyMan() {

    }

    public static LazyMan getLazyMan() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
    // 线程安全
    public static synchronized LazyMan getLazyMan_salf() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}
