package com.example.demo.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 10450
 * @description TODO
 * @date 2021/3/4 10:52
 */
public class DateUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public static Date parseString2Date(String date, String format) throws ParseException {
        if(StringUtils.isEmpty(date)){
            return null;
        }
        return new SimpleDateFormat(format).parse(date);
    }

    public static String getStringDateByDate(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    public static String getNowStringDateByDate(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getStringDateByDate(new Date(),DATE_FORMAT));

    }
}
