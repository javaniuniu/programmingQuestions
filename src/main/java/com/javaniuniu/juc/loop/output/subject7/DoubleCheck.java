package com.javaniuniu.juc.loop.output.subject7;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 9:34 AM
 */
public class DoubleCheck {

    private static volatile DoubleCheck doubleCheck = null;

    private DoubleCheck(){
//        doubleCheck = new DoubleCheck();
    }

    public DoubleCheck getDoubleCheck() {
        if (doubleCheck==null) {
            synchronized (DoubleCheck.class){
                if (doubleCheck==null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }

        return doubleCheck;
    }
}
