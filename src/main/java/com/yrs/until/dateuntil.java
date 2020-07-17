package com.yrs.until;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统当前日期格式化工具类
 */
public class dateuntil {
    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
