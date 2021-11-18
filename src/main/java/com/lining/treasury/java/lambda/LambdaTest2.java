package com.lining.treasury.java.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lining
 */
public class LambdaTest2 {

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

        //无参，无返回值
        Runnable r2 = () -> System.out.println("Lambda2!");
        r2.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Lambda!");

        Consumer<String> consumer2 = (String s) -> {
            System.out.println(s);
        };
        consumer2.accept("Lambda2!");
    }

    @Test
    public void test3() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Lambda!");

        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };

        consumer2.accept("Lambda2!");
    }

    @Test
    public void test4() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Lambda!");

        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };

        consumer2.accept("Lambda2!");
    }

    @Test
    public void test5() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare1 = comparator1.compare(12, 11);
        System.out.println(compare1);

        Comparator<Integer> comparator2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int compare2 = comparator2.compare(12, 13);
        System.out.println(compare2);
    }

    @Test
    public void test6() {


        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);

        int compare2 = comparator2.compare(12, 13);
        System.out.println(compare2);
    }
}
