package com.lining.treasury.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lining
 * @date 2019/10/18
 * @description DateUtil 日期工具类
 */
public class DateUtil {
    /**
     * 得到某个日期前几天或后几天的日期
     *
     * @param date 日期
     * @param days 天数
     * @param type 1 前几天 2 后几天
     * @return 日期
     */
    public static Date getBeforeOrAfterDayByCalendar(Date date, int days, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, type == 1 ? (-(days)) : days);
        return calendar.getTime();
    }

}
