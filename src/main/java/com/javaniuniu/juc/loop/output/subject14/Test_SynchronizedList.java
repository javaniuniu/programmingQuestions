package com.javaniuniu.juc.loop.output.subject14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther: javaniuniu
 * @date: 2020/9/2 9:42 AM
 */
public class Test_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
