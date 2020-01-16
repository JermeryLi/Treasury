package com.lining.treasury.util.excel;

import com.alibaba.excel.EasyExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lining
 * @date 2020/1/13
 * @description ExcelTestController
 */
@Controller
@RequestMapping(value = "excel")
public class ExcelTestController {
    @RequestMapping("")
    public String excel(){
        return "excel/excel";
    }

    @RequestMapping("write")
    public void writeExcel(HttpServletResponse response) throws Exception{
        //模拟数据
        List<Person> list = new ArrayList<Person>() {{
            add(new Person("lining", 24, 1, new Date()));
            add(new Person("lining", 24, 1, new Date()));
            add(new Person("lining", 24, 1, new Date()));
        }};
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("人员信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Person.class).sheet("人员").doWrite(list);
    }

}
