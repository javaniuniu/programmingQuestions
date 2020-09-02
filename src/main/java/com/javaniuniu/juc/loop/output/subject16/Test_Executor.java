package com.javaniuniu.juc.loop.output.subject16;

import java.util.concurrent.Executor;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 6:28 PM
 */
public class Test_Executor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new Test_Executor().execute(()->{
            System.out.println("hello Executor");
        });
    }
}
