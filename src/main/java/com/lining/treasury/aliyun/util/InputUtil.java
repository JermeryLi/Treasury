package com.lining.treasury.aliyun.util;

import java.util.Scanner;

/**
 * @author lining
 * @date 2020/3/30
 * @description InputUtil
 */
public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String msg) {
        System.out.print(msg);
        return scanner.next();
    }
}
