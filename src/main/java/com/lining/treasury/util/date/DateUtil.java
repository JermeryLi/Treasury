package com.lining.treasury.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lining
 * @date 2019/10/18
 * @description DateUtil 日期工具类
 */
public class DateUtil {

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * 得到某个日期前几天或后几天的日期
     * @param date 日期
     * @param days 天数 days可以为负数
     * @return 日期
     */
    public static Date getBeforeOrAfterDayByCalendar(Date date, int days) {
        if (days == 0){
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 日期按照格式转换为字符串
     * @param date    日期
     * @param pattern 格式
     * @return String
     */
    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 字符串按照格式转换为日期
     * @param dateString 日期型字符串
     * @param pattern    转换格式
     * @return date
     */
    public static Date stringToDate(String dateString, String pattern) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
