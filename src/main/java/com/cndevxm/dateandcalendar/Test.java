package com.cndevxm.dateandcalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yulin Ma
 * Date 2019/1/24
 * Description
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        /**
         * Date
         */
        System.out.println("*****************Date相关操作");
        Date date = new Date();
        String dateString = "2019-01-01 23:23:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date));
        System.out.println(sdf.parse(dateString));

        /**
         * Calendar
         */
        System.out.println("*****************Calendar相关操作");
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar 获取毫秒数：" + calendar.getTimeInMillis());
        System.out.println("Calendar 获取当前时间：" + calendar.getTime());

        Calendar tCalendar = Calendar.getInstance();
        tCalendar.set(2019, 1, 1, 23, 23, 59);
        tCalendar.add(Calendar.YEAR, 1);
        tCalendar.add(Calendar.MONTH, 1);
        tCalendar.add(Calendar.DAY_OF_MONTH, 1);
        tCalendar.add(Calendar.HOUR_OF_DAY, 1);
        tCalendar.add(Calendar.MINUTE, 1);
        tCalendar.add(Calendar.SECOND, 1);

        System.out.println("Calendar 获取当前年：" + tCalendar.get(Calendar.YEAR));
        System.out.println("Calendar 获取当前月：" + tCalendar.get(Calendar.MONTH));
        System.out.println("Calendar 获取当前日：" + tCalendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Calendar 获取当前时：" + tCalendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Calendar 获取当前分：" + tCalendar.get(Calendar.MINUTE));
        System.out.println("Calendar 获取当前秒：" + tCalendar.get(Calendar.SECOND));

        /**
         * jdk1.8 时间api
         */
        System.out.println("*****************LocalDate相关操作");
        LocalDate localDate = LocalDate.now();
        LocalDate tLocalDate = LocalDate.of(2019, 01, 01);
        System.out.println("LocalDate 获取当前年：" + tLocalDate.getYear());
        System.out.println("LocalDate 获取当前月：" + tLocalDate.getMonth());
        System.out.println("LocalDate 获取当前日：" + tLocalDate.getDayOfMonth());
        System.out.println("LocalDate 获取当前日在一周：" + tLocalDate.getDayOfWeek());
        System.out.println("LocalDate 获取当前月长度：" + tLocalDate.lengthOfMonth());
        System.out.println("LocalDate 是否闰年：" + tLocalDate.isLeapYear());
        System.out.println("LocalDate 获取当前年：" + tLocalDate.get(ChronoField.YEAR));
        System.out.println("LocalDate 获取当前月：" + tLocalDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("LocalDate 获取当前日：" + tLocalDate.get(ChronoField.DAY_OF_MONTH));

        System.out.println("*****************LocalTime相关操作");
        LocalTime localTime = LocalTime.now();
        LocalTime tlocalTime = LocalTime.of(23, 59, 59);
        System.out.println("LocalTime 获取当前时：" + tlocalTime.getHour());
        System.out.println("LocalTime 获取当前分：" + tlocalTime.getMinute());
        System.out.println("LocalTime 获取当前秒：" + tlocalTime.getSecond());
        System.out.println("LocalTime 获取当前时：" + tlocalTime.get(ChronoField.HOUR_OF_DAY));
        System.out.println("LocalTime 获取当前分：" + tlocalTime.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("LocalTime 获取当前秒：" + tlocalTime.get(ChronoField.SECOND_OF_MINUTE));

        System.out.println("*****************LocalDateTime相关操作");
        LocalDateTime localDateTime = LocalDateTime.of(2019, 01, 01, 23, 23, 59);
        LocalDate date1 = localDateTime.toLocalDate();
        LocalTime time1 = localDateTime.toLocalTime();

    }
}
