package com.cgy.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GyuanYuan Cai
 * 2021/10/5
 * Description:
 */

public class DateConverter implements Converter<String, Date> {

    // source就是表单传递过来的请求参数
    @Override
    public Date convert(String source) {
        // 将日期字符串转换成日期对象，进行返回
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}