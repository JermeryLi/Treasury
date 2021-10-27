package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import java.util.concurrent.ExecutorService;

/**
 * @author lining
 * wait notify
 */
public class WaitDemo {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char word : words) {
                    System.out.print(word);
                    try {
                        o.notify();
                        o.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                try {
                    //首先wait等待t1唤醒，保证肯定先输出字母。
                    o.wait();
                    for (char number : numbers) {
                        System.out.print(number);
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.notify();
            }

        }, "t2").start();

    }
}
