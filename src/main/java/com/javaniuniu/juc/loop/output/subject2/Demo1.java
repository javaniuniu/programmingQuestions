
/**
 * 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z；
 */
package com.javaniuniu.juc.loop.output.subject2;

// 升级版
public class Demo1 {
    static class Behaver{
        private volatile boolean flag=true;
        private volatile int count=1;
        public synchronized void printNum(){
            while(!flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(count*2-1);
            System.out.print(count*2);
            flag=false;
            this.notify();
        }
        public synchronized void printChar(){
            while(flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print((char)(count+'A'-1));
            count++;
            flag = true;
            this.notify();
        }
    }

    public static void main(String[] args) {
        Behaver behaver=new Behaver();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                behaver.printNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                behaver.printChar();
            }
        }).start();
    }
}