package com.lining.treasury.java.thread.failUndo;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 */
public class FailUndo {

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

    public static void main(String[] args) {
        Boss boss = new Boss();
        Worker worker = new Worker(boss, "t1", 3, true);
    }

    private static enum Result {
        NOTSET, SUCCESSED, FAILED, CANCELLED
    }

    private static class Worker extends Thread {
        public Worker(Boss boss, String name, int timeSeconds, boolean success) {
            this.boss = boss;
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }
        @Override
        public void run(){
            int interval = 100;
            int total = 0;
            for(;;){
                try {
                    Thread.sleep(interval);
                    total += interval;
                    if(total / 1000 >= timeSeconds){
                        System.out.println(name + "任务结束!" + result);
                        result = success ? Result.SUCCESSED : Result.FAILED;
                        break;
                    }
                    if(cancelling){
//                        rollback();
                        result = Result.CANCELLED;
                        cancelling = false;
                        System.out.println(name + "任务结束！" + result);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boss.end(this);
        }

        private Result result = Result.NOTSET;

        private Boss boss;
        private String name;
        private int timeSeconds;
        private boolean success;
        private volatile boolean cancelling = false;


        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public Boss getBoss() {
            return boss;
        }

        public void setBoss(Boss boss) {
            this.boss = boss;
        }

        public int getTimeSeconds() {
            return timeSeconds;
        }

        public void setTimeSeconds(int timeSeconds) {
            this.timeSeconds = timeSeconds;
        }

        public void cancel() {

        }
    }
}
