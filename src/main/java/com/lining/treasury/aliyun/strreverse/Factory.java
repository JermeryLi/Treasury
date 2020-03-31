package com.lining.treasury.aliyun.strreverse;

/**
 * @author lining
 * @date 2020/3/30
 * @description Factory
 */
public class Factory {
    private Factory() {
    }

    public static IStringService getInstance() {
        return new StringServiceImpl();
    }
}
