package com.lining.treasury.java.thread.failUndo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 * 引入了管理者的概念，不是循环监视，而是如果任务失败了，启用通知
 */
public class T00_F3 {
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
        private List<Worker> tasks = new ArrayList<>();

        public void addTask(Worker t) {
            tasks.add(t);
        }

        @Override
        public void run() {
            tasks.stream().forEach((t) -> t.start());
        }


        public void end(Worker worker) {
            if (worker.getResult() == Result.FAILED) {
                System.exit(0);
            }
        }

    }

    private static enum Result {
        NOTEND, SUCCEED, FAILED
    }

    private static class Worker extends Thread {
        private Result result = Result.NOTEND;
        private Boss boss;
        private String name;
        private int timeSeconds;
        private boolean success;

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
            try {
                Thread.sleep(timeSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "任务结束！");
            result = success ? Result.SUCCEED : Result.FAILED;
            //当一条任务失败，通知boss结束
            boss.end(this);
        }
    }
}
