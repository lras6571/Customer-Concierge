package com.sysco.mdm_customer.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    private DateUtils() {
    }

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String currentDate = sdf.format(date);
        return currentDate;
    }

    public static String getQCenterBuildDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String todayDate = sdf.format(calendar.getTime());
        return todayDate;
    }

    public static String getFutureDate(int numOfDays) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String futureDate = sdf.format(date);

        return futureDate;
    }

    public static String getFutureDate(int numOfDays, String strFormat) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, numOfDays);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String futureDate = sdf.format(date);

        return futureDate;
    }

    public static String getDayOfWeekOfGivenDate(String date) {
        String dayOfWeek = "";
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
            Date dt1 = format1.parse(date);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            dayOfWeek = format2.format(dt1);
        }
        catch (Exception e) {

        }
        return dayOfWeek;
    }

}
