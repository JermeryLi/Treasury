package com.lining.treasury.aliyun.filesave;

import java.io.File;

/**
 * @author lining
 * @date 2020/3/30
 * @description FileSave
 * @website https://developer.aliyun.com/article/747735?groupCode=java
 */
public class FileSave {
    private static final String SAVE_DIR =  "D:/aliyun/";
    static {
        File file = new File(SAVE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    public static void main(String[] args) {
        IFileService fileService = Factory.getInstance();
        System.out.println(fileService.save());
    }
}
