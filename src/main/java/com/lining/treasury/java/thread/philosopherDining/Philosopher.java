package com.lining.treasury.java.thread.philosopherDining;

/**
 * 哲学家
 *
 * @author lining
 */

public class Philosopher extends Thread {
    private ChopStick left;
    private ChopStick right;
    private int index;

    public Philosopher(String name, int index, ChopStick left, ChopStick right) {
        this.setName(name);
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        //左撇子算法，也可以index % 2 == 0
        if (index == 0) {
            synchronized (left) {
                try {
                    Thread.sleep(1000L);
                    synchronized (right) {
                        Thread.sleep(1000L);
                        System.out.println(index + "号 哲学家已经吃完");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            synchronized (right) {
                try {
                    Thread.sleep(1000L);
                    synchronized (left) {
                        Thread.sleep(1000L);
                        System.out.println(index + "号 哲学家已经吃完");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ChopStick getLeft() {
        return left;
    }

    public void setLeft(ChopStick left) {
        this.left = left;
    }

    public ChopStick getRight() {
        return right;
    }

    public void setRight(ChopStick right) {
        this.right = right;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
