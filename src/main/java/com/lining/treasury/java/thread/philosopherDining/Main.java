package com.lining.treasury.java.thread.philosopherDining;

/**
 * @author lining
 */
public class Main {
    public static void main(String[] args) {
        ChopStick cs0 = new ChopStick();
        ChopStick cs1 = new ChopStick();
        ChopStick cs2 = new ChopStick();
        ChopStick cs3 = new ChopStick();
        ChopStick cs4 = new ChopStick();

        Philosopher p0 = new Philosopher("p0", 0, cs0, cs1);
        Philosopher p1 = new Philosopher("p1", 1, cs1, cs2);
        Philosopher p2 = new Philosopher("p2", 2, cs2, cs3);
        Philosopher p3 = new Philosopher("p3", 3, cs3, cs4);
        Philosopher p4 = new Philosopher("p4", 4, cs4, cs0);

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();

    }
}
