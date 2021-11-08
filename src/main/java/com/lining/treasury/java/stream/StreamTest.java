package com.lining.treasury.java.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author lining
 */
public class StreamTest {
    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,3};
        IntStream stream = Arrays.stream(arr);
        stream.limit(1).forEach(s -> System.out.println(s));
    }
}
