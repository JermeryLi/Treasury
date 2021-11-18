package com.lining.treasury.java.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author lining
 * Lambda表达式的使用举例
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Lambda!");
            }
        };
        r1.run();

        System.out.println("***********");

        Runnable r2 = () -> System.out.println("Lambda2!");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = comparator.compare(12, 11);
        System.out.println(compare1);

        System.out.println("***************");
        // Lambda 表达式的写法
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = comparator2.compare(12, 13);
        System.out.println(compare2);

        // 方法引用
        Comparator<Integer> comparator3 = Integer :: compare;
        int compare3 = comparator3.compare(12,14);
        System.out.println(compare3);
    }
}
