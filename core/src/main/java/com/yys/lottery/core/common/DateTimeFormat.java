package com.yys.lottery.core.common;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {

    public static String  forMatDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  dateFormat.format(date);
    }

    /**
     * @describe 验证日期
     * @param strDate
     * @return
     */
    public static boolean isValidDate(String strDate){
        boolean flag = false;
        if (StringUtils.isNotEmpty(strDate)){
            SimpleDateFormat format;
            if (strDate.length()>10){
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else {
                format = new SimpleDateFormat("yyyy-MM-dd");
            }
            format.setLenient(false);
            try {
                format.parse(strDate);
                flag = true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
