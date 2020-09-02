package com.javaniuniu.juc.loop.output.subject16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @auther: javaniuniu
 * @date: 2020/9/3 12:55 AM
 */
public class Test_ParallelStreamAPI {
    static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
        for(int i=0; i<10000; i++) nums.add(1000000 + r.nextInt(1000000));
    }
    public static void main(String[] args) {


        //System.out.println(nums);

        // 使用 stream 流api
        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        // 使用 多线程流 同时处理
        start = System.currentTimeMillis();
        nums.parallelStream().forEach(Test_ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void foreach() {
        nums.forEach(v->isPrime(v));
    }

    public static void parallelStream() {
        nums.parallelStream().forEach(Test_ParallelStreamAPI::isPrime);
    }

}
