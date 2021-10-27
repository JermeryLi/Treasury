package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import ch.qos.logback.core.spi.LogbackLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lining
 */
public class LockConditionDemo {
    public static void main(String[] args) {
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            lock.lock();
            try {
                for (char word : words) {
                    System.out.print(word);
                    latch.countDown();
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (char number : numbers) {
                    System.out.print(number);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();



    }
}
