package com.javaniuniu.juc.loop.output.subject7;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 9:34 AM
 */
public class HungerMan {
    private final static HungerMan hungerMan = new HungerMan();

    private HungerMan() {
    }

    public static HungerMan getHungerMan() {
        return hungerMan;
    }




}
