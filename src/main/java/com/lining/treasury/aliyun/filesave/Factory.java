package com.lining.treasury.aliyun.filesave;

/**
 * @author lining
 * @date 2020/3/30
 * @description Factory
 */
public class Factory {
    private Factory(){}
    public static IFileService getInstance(){
        return new FileServiceImpl();
    }
}
