package com.kozyrev.iLoveHibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDate(String dateString) throws ParseException{
        Date date = formatter.parse(dateString);
        return date;
    }
    public static String formatDate(Date date) {
        String result = null;
        if (date != null) {
            result = formatter.format(date);
        }
        return result;
    }
}
