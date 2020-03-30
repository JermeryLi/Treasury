package com.lining.treasury.aliyun.oddevennumberscount;

/**
 * @author lining
 * @date 2020/3/30
 * @description Factory
 */
public class Factory {

    private Factory() {
    }

    public static INumberService getInstance() {
        return new NumberServiceImpl();
    }
}

