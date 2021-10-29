package com.lining.treasury.java.thread.failUndo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 */
public class T00_F5 {
    public static void main(String[] args) throws Exception {
        Boss boss = new Boss();
        Worker t1 = new Worker(boss, "t1", 3, true);
        Worker t2 = new Worker(boss, "t2", 4, true);
        Worker t3 = new Worker(boss, "t3", 1, false);

        boss.addTask(t1);
        boss.addTask(t2);
        boss.addTask(t3);

        boss.start();
        System.in.read();
    }

    private static class Boss extends Thread {
        private List<Worker> workers = new ArrayList<>();

        public void addTask(Worker t) {
            workers.add(t);
        }

        @Override
        public void run() {
            workers.stream().forEach((t) -> t.start());
        }


        public void end(Worker worker) {
            if (worker.getResult() == Result.FAILED) {
                cancel(worker);
            }
        }

        public void cancel(Worker worker) {
            for (Worker w : workers) {
                if (w != worker) {
                    w.cancel();
                }
            }
        }

    }

    private static enum Result {
        NOTSET, SUCCEED, FAILED, CANCELLED
    }

    private static class Worker extends Thread {
        private Result result = Result.NOTSET;

        private Boss boss;
        private String name;
        private int timeSeconds;
        private boolean success;

        private volatile boolean cancelling = false;

        public Worker(Boss boss, String name, int timeSeconds, boolean success) {
            this.boss = boss;
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }

        public Result getResult() {
            return result;
        }

        @Override
        public void run() {
            int interval = 100;
            int total = 0;
            for (; ; ) {
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                total += interval;
                if (total / 1000 >= timeSeconds) {
                    System.out.println(name + "任务结束！" + result);
                    result = success ? Result.SUCCEED : Result.FAILED;
                    break;
                }
                if (cancelling) {
                    rollback();
                    result = Result.CANCELLED;
                    cancelling = false;
                    System.out.println(name + "任务结束！" + result);
                    break;
                }
            }
            boss.end(this);
        }

        public void cancel() {
            //当一个任务取消的时候，这个任务能够更加取消回退的过程。
            //所以回退过程 由当前任务回退。
            cancelling = true;
        }

        public void rollback() {
            //如何书写回滚
            System.out.println(name + "rollback start！");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "rollback end！");
        }
    }
}
