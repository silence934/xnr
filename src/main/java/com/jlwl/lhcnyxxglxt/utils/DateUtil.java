package com.jlwl.lhcnyxxglxt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String convertString(Date date,String format){
        if(date == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
