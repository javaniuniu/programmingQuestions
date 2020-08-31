package com.javaniuniu.juc.loop.output.subject6;

/**
 * @auther: javaniuniu
 * @date: 2020/8/31 8:30 AM
 */
public  class T2 {
    private volatile int flag = 1;

    private synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            while (flag != 1) { // 如果不为1 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            flag = 2;
            this.notifyAll();
        }
    }

    private synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            while (flag != 2) { // 如果不为2 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            flag = 3;
            this.notifyAll();
        }
    }

    private synchronized void printC() {
        for (int i = 0; i < 5; i++) {
            while (flag != 3) { // 如果不为2 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("C");
            flag = 1;
            this.notifyAll();
        }
    }

//    private synchronized void printC() {
//        for (int i = 0; i < 5; i++) {
//            if (flag != 3) { // 如果不为3 ，说明还没有轮到当前线程执行方法，则进入wait方法，释放对象锁
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.print("C");
//            flag = 1;
//            this.notifyAll();
//        }
//    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        new Thread(t2::printA, "A").start();
        new Thread(t2::printB, "B").start();
        new Thread(t2::printC, "C").start();
    }
}
