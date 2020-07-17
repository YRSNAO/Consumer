package com.yrs.until;


import java.text.SimpleDateFormat;
import java.util.Date;

public class dateuntil {
    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
