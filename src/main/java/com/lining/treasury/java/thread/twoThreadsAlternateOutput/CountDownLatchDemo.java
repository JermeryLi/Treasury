package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import java.util.concurrent.CountDownLatch;

/**
 * @author lining
 */
public class CountDownLatchDemo {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        final Object o = new Object();
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();


        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char number : numbers) {
                    System.out.print(number);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notify();
            }
        },"t2").start();

        new Thread(() -> {
            synchronized (o) {
                for (char word : words) {
                    System.out.print(word);
                    latch.countDown();
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


    }
}
