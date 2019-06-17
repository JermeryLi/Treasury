package com.lining.treasury.demo;

import java.math.BigDecimal;

/**
 * @Author: lining
 * @Date: 2019/6/17 21:17
 * @Description:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}

//推荐b的赋值方式
