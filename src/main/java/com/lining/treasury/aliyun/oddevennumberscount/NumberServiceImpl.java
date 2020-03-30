package com.lining.treasury.aliyun.oddevennumberscount;

import com.lining.treasury.aliyun.util.InputUtil;

/**
 * @author lining
 * @date 2020/3/30
 * @description NumberServiceImpl
 * @website: https://developer.aliyun.com/article/747944?groupCode=java
 */
public class NumberServiceImpl implements INumberService {
    @Override
    public int[] stat() {
        //第一个为偶数，第二个为奇数
        int[] stat = new int[]{0, 0};
        String str = InputUtil.getString("请输入数字信息：");
        //按照每个字符拆分
        String[] result = str.split("");
        for (String s : result) {
            if (Integer.parseInt(s) % 2 == 0) {
                stat[0]++;
            } else {
                stat[1]++;
            }
        }
        return stat;
    }
}
