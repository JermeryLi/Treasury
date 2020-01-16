package com.lining.treasury.util.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.converters.AutoConverter;
import lombok.Data;

import java.net.URL;
import java.util.Date;

/**
 * @author lining
 * @date 2019/11/18
 * @description Person
 */
@Data
@ColumnWidth(25)
@HeadRowHeight(20)
@ContentRowHeight(50)
public class Person {
    @ExcelProperty(value = {"人员信息", "姓名"}, index = 0, converter = AutoConverter.class)
    private String name;
    @ExcelProperty(value = {"人员信息","年龄"}, index = 1)
    private int age;
    @ExcelProperty(value = {"人员信息","性别"}, index = 2)
    private int sex;
    @ExcelProperty(value = "生日")
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date date;
    @ExcelIgnore
    private String ignore;
    @ExcelProperty(value = "图片")
    private URL url;

    public Person(String name, int age, int sex, Date date) throws Exception {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.url = new URL("https://wx2.sinaimg.cn/mw690/8345c393ly1g926qez2f9j23jk1zsnpf.jpg");
    }
}
