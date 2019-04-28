package com.lining.treasury.algorithm.sort;

import java.util.Arrays;

/**
 * @author lining
 * @date 2019/4/26
 * @description SelectionSort 选择排序
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //要经过length-1次排序
        for (int i = 0, length = arr.length; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1, size = arr.length; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        IArraySort sort = new SelectionSort();
        int[] sourceArr = {2, 5, 3, 1, 0};
        int[] targetArr = sort.sort(sourceArr);
        for (int i = 0; i < targetArr.length; i++) {
            System.out.println(targetArr[i]);
        }
    }
}
