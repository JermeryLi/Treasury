package com.lining.treasury.java.thread.bottomSynchronization;

/**
 * @author lining
 */
public class EscapeDemo {
    private int num = 8;

    public EscapeDemo() {
        new Thread(() -> {
            System.out.println(this.num);
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new EscapeDemo();
        System.in.read();
    }


    //num 有可能为0
    //永远不要在构造方法里启动线程。
}
