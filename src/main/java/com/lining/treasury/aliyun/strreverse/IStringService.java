package com.lining.treasury.aliyun.strreverse;

/**
 * @author lining
 * @date 2020/3/30
 * @description IStringService
 */
public interface IStringService {
    /***
     * 追加数据
     * @param str 字符串
     */
    void append(String str);

    /**
     * 反转处理
     * @return 反转
     */
    String[] reverse();
}
