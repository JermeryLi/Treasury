package com.lining.treasury.java.thread.failUndo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 */
public class T00_F2 {
    public static void main(String[] args) throws Exception {
        MyTask t1 = new MyTask("t1", 3, true);
        MyTask t2 = new MyTask("t2", 4, true);
        MyTask t3 = new MyTask("t3", 1, true);

        List<MyTask> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        tasks.stream().forEach((t) -> t.start());

        //死循环 不优雅
        for (; ; ) {
            for (MyTask task : tasks) {
                if (task.getResult() == Result.FAILED){
                    System.exit(0);
                }
            }
        }
    }

    private static enum Result {
        NOTEND, SUCCEED, FAILED
    }

    private static class MyTask extends Thread {
        private Result result = Result.NOTEND;
        private String name;
        private int timeSeconds;
        private boolean success;

        public MyTask(String name, int timeSeconds, boolean success) {
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }

        public Result getResult() {
            return result;
        }

        @Override
        public void run(){
            //模拟业务执行时间
            //实际中业务不固定，可能在处理计算任务，或者是IO任务
            try {
                Thread.sleep(timeSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "任务结束！");
            //如果失败了，没有处理脏数据（回退）
            result = success ? Result.SUCCEED : Result.FAILED;
        }
    }
}
