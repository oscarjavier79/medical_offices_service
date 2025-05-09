package com.mx.offices.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public enum DateUtil {
    INSTANCE;
    public Date stringToDate(String sDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
        return formatter.parse(sDate);
    }

    public String dateToString(Date dDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }
}
