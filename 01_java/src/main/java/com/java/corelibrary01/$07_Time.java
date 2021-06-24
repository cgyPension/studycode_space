package com.java.corelibrary01;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/6/21
 * Description:
 */

public class $07_Time {
    public static void main(String[] args) {

        //1.获取当前系统时间距离1970年1月1日0时0分日秒的毫秒数
        long msec = System.currentTimeMillis();
        System.out.println("当前系统时间距离1970年1月1日0时0分0秒已经过去" +msec + "毫秒了!");//通常用于测试某一段代码的执行效率

        System.out.println("------------------------Date--已经不建议用----------------------------");
        Date d1 = new Date();
        System.out.println("获取当前系统时间 " + d1);

        // 使用参数指定的毫秒数来构造Date对象并打印 1 秒 = 1000毫秒 东八区
        Date d2 = new Date(1000);
        System.out.println("d2 = " + d2); // 1970 11 001

        long msec1 = d2.getTime();
        System.out.println("获取到的毫秒数是： " + msec1);

        // 设置调用对象所表示的时间点为参数指定的毫秒数
        d2.setTime(2000);
        System.out.println("修改后的时间是： " + d2); // 1970 11 80 2

        System.out.println("-------------------------SimpleDateFormat------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("转换后的时间格式："+sdf.format(d1));

//        Long aLong = Long.valueOf("36976194256520086443");
        Long aLong = Long.valueOf("36976194256");
        System.out.println("aLong = " + aLong);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        BigInteger maxInt = new BigInteger("36976194256520086443");
        System.out.println("maxInt = " + maxInt);

        long l1 = Timestamp.valueOf("1970-01-01 08:00:00").getTime(); // 我们是东八区
        System.out.println("转为时间戳 " + l1);

        System.out.println(StringUtils.isBlank(null) ? "1970-01-01 08:00:00" : "66666");

        System.out.println("-------------------------Calendar------------------------------");
         // 获取Calendar类型引用
        //既然calendar是个抽象类不能创建对象, 那么下面的方法为啥可以获取calendar类型的引用呢?
        // 解析：由源码可知，返回的并不是calendar类型的对象,而是Calendar类的子类Gregoriancalendar等对象．
        Calendar instance = Calendar.getInstance();
        // 设置指定的年月日时分秒信息
        instance.set(2008,7,8,20,8,8);
        Date d3 = instance.getTime();
        System.out.println("sdf.format(d3) = " + sdf.format(d3));
        // 向指定的字段设置值
        instance.set(Calendar.YEAR,2021);
        System.out.println("修改年份 " + sdf.format(instance.getTime()));
        instance.set(Calendar.MONTH,2);
        System.out.println("修改月份 结果是+1：" + sdf.format(instance.getTime()));
        instance.add(Calendar.MONTH,5);
        System.out.println("增加月份：" + sdf.format(instance.getTime()));

        System.out.println("--------------------一般情况下更推荐--LocalDate------------------------------");
        LocalDate today = LocalDate.now();// 今天
        LocalDate yesterday = today.plusDays(-1); // 昨天
        System.out.println("昨天：" + yesterday);

        System.out.println("-------------------------LocalTime------------------------------");
        LocalTime todayTime = LocalTime.now();
        System.out.println("todayTime = " + todayTime);

        System.out.println("-------------------------LocalDateTime------------------------------");
        LocalDateTime todayDateTime = LocalDateTime.now();
        System.out.println("todayDateTime = " + todayDateTime);
        LocalDateTime of = LocalDateTime.of(2008, 8, 8, 8, 8, 8);
        System.out.println("指定日期的时间是 " + of);
        System.out.println("获取的年是： " + of.getYear());
        // 修改年 返回值相当于创建了一个新对象
        System.out.println("of.withYear(2021) = " + of.withYear(2021));
        System.out.println("增加两天： " + of.plusDays(2));

        System.out.println("-------------------------DateTimeFormatter------------------------------");
        /**
         * Desc:  日期转换的工具类
         *     SimpleDateFormat存在线程安全问题,底层调用 calendar.setTime(date);
         *     解决：在JDK8，提供了DateTimeFormatter替代SimpleDateFormat
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = dtf.format(todayDateTime);
        System.out.println("调整后的结果是： " + str);
        TemporalAccessor parse = dtf.parse(str);
        System.out.println("转回去的结果是： " + parse);

        System.out.println("本地时区： " + ZoneId.systemDefault());

        // 将字符串日期转换为时间毫秒数
        String dateStr = "2021-06-24 20:41:10";
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, dtf);
        long ts = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("将字符串日期转换为时间毫秒数：" + ts);


        System.out.println("-------------------------Instant------------------------------");
        //1.使用Instant类来获取当前系统时间并不是当前系统的默认时区本初子午线 差8小时东n区
        Instant now = Instant.now();
        System.out.println("当前的时间是： " + now);
        System.out.println("加上时区所差的8小时 " + now.atOffset(ZoneOffset.ofHours(8)));

        System.out.println("获取当前对象距离标准基准时间的毫秒数 " + now.toEpochMilli());

        Instant instant = Instant.ofEpochMilli(1624368256366L);
        System.out.println("根据参数指定的毫秒数构造出来的对象为: " + instant);


    }

}