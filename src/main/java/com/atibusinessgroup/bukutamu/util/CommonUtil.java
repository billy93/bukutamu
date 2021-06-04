package com.atibusinessgroup.bukutamu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    public static boolean isNotNullOrEmpty(String str) {
        if (str == null || str == "") {
            return false;
        }
        return true;
    }

    public static boolean isStrValidDate(String str, String format) {
        try {
            Date date = new SimpleDateFormat(format).parse(str);
            return date != null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}