package com.lining.treasury.java.thread.failUndo;

/**
 * @author lining
 */
public class T00_F1 {
    public static void main(String[] args) throws Exception{
        Thread t1 = new MyTask("t1", 3, true);
        Thread t2 = new MyTask("t2", 4, true);
        Thread t3 = new MyTask("t3", 1, true);
        t1.start();
        t2.start();
        t3.start();

        System.in.read();
    }


    private static class MyTask extends Thread{
        private String name;
        private int timeSeconds;
        private boolean success;

        public MyTask(String name, int timeSeconds, boolean success){
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }
    }
}
