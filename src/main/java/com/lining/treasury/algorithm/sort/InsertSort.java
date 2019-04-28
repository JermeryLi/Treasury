package com.lining.treasury.algorithm.sort;

import java.util.Arrays;

/**
 * @author lining
 * @date 2019/4/26
 * @description InsertSort
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1, length = arr.length; i < length; i++) {
            int temp = arr[i];

            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
