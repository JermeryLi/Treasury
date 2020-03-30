package com.lining.treasury.aliyun.oddevennumberscount;

import java.util.Arrays;

/**
 * @author lining
 * @date 2020/3/30
 * @description NumbersCount
 */
public class NumbersCount {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Factory.getInstance().stat()));
    }
}
