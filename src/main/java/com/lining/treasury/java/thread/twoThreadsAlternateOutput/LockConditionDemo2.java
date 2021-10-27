package com.lining.treasury.java.thread.twoThreadsAlternateOutput;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lining
 * 循环打印abc
 */
public class LockConditionDemo2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(2);

        String[] arr1 = {"a","a","a"};
        String[] arr2 = {"b","b","b"};
        String[] arr3 = {"c","c","c"};


        new Thread(()->{
            lock.lock();
            try {
                for (String s : arr1) {
                    System.out.print(s);
                    latch1.countDown();
                    latch2.countDown();
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                latch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (String s : arr2) {
                    System.out.print(s);
                    latch2.countDown();
                    condition3.signal();
                    condition2.await();
                }
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (String s : arr3) {
                    System.out.print(s);
                    condition1.signal();
                    condition3.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
