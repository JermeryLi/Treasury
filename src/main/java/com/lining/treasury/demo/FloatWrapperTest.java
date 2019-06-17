package com.lining.treasury.demo;

/**
 * @Author: lining
 * @Date: 2019/6/17 21:13
 * @Description:
 */
public class FloatWrapperTest {
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if (a.equals(b)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
