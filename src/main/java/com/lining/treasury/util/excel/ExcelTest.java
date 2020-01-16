package com.lining.treasury.util.excel;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lining
 * @date 2019/11/18
 * @description ExcelTest
 */
public class ExcelTest {
    public static void main(String[] args) throws Exception {
        String fileName = "D:\\人员信息.xlsx";
        List<Person> list = new ArrayList<Person>() {{
            add(new Person("lining", 24, 1, new Date()));
            add(new Person("lining", 24, 1, new Date()));
            add(new Person("lining", 24, 1, new Date()));
        }};
        EasyExcel.write(fileName, Person.class).sheet("信息").doWrite(list);
    }
}
