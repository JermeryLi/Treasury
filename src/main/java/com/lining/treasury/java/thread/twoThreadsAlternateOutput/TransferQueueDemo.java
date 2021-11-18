package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author lining
 */
public class TransferQueueDemo {
    public static void main(String[] args) {
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                for (char word : words) {
                    System.out.print(queue.take());
                    queue.tryTransfer(word);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                for (char number : numbers) {
                    queue.tryTransfer(number);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
