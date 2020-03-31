package com.lining.treasury.aliyun.filesave;

import java.io.File;

/**
 * @author lining
 * @date 2020/3/30
 * @description IFileService
 */
public interface IFileService {
    public static final String SAVE_DIR = "D:" + File.separator + "aliyun" + File.separator;
    /**
     * 定义文件的保存处理方法
     * @return 保存成功为true，保存失败返回false
     */
    public boolean save();
}
