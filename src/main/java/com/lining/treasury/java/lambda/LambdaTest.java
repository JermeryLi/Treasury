package com.lining.treasury.java.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author lining
 * Lambda表达式的使用举例
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                System.out.println("Lambda!");
            }
        };
        r1.run();

        System.out.println("***********");

        Runnable r2 = ()-> System.out.println("Lambda2!");
        r2.run();
    }

    @Test
    public void test2() {
    }
}
