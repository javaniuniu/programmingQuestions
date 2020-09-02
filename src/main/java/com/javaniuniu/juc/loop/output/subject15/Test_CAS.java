package com.javaniuniu.juc.loop.output.subject15;

/**
 * @auther: javaniuniu
 * @date: 2020/9/3 12:39 AM
 */
// 通过枚举的方式做判断
public class Test_CAS {
    enum ReadyToRun{T1,T2};
    static volatile ReadyToRun r = ReadyToRun.T1; //思考为什么必须volatile

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            for(char c:aI) {
                while (r!=ReadyToRun.T1) {
                    System.out.println(c);
                    r = ReadyToRun.T2;
                }
            }
        },"t1").start();
        new Thread(()->{
            for(char c:aC) {
                while (r!=ReadyToRun.T2) {
                    System.out.println(c);
                    r = ReadyToRun.T1;
                }
            }
        },"t2").start();

    }
}
