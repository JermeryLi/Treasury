package com.lining.treasury.demo;

/**
 * @Author: lining
 * @Date: 2019/6/17 21:15
 * @Description:
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
