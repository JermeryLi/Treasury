package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import java.util.concurrent.locks.LockSupport;

/**
 * @author lining
 */
public class LockSupportDemo {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();

        t1 = new Thread(() -> {
            for (char word : words) {
                System.out.print(word);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");


        t2 = new Thread(() -> {
            for (char number : numbers) {
                LockSupport.park();
                System.out.print(number);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();


    }
}
