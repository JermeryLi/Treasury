package com.lining.treasury.aliyun.util;

import java.util.Scanner;

/**
 * @author lining
 * @date 2020/3/30
 * @description InputUtil
 */
public class InputUtil {

    public static String getString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        return scanner.next();
    }

    /**
     * 实现键盘接收数字的操作
     * @param prompt 提示信息
     * @return 一个可以使用的数字
     */
    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.print(prompt);  //打印提示信息
            if(input.hasNext("\\d+")){
                num = Integer.parseInt(input.next("\\d+"));
                flag = false ;
            }else{
                System.out.println("输入的内容不是数字！");
            }
        }
        return num ;
    }
}
