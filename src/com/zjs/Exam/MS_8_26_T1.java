package com.zjs.Exam;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/8/16 18:56
 **/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class MS_8_26_T1 {
    public static String weekToDayFormat(int year, int month, int week, int day) {
        Calendar calendar = Calendar.getInstance();
        // 注意这里要修改为周一为一周的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.WEEK_OF_MONTH, week);
        calendar.set(Calendar.DAY_OF_WEEK, day + 1);
        String outDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        int outMonth = Integer.parseInt(outDate.split("-")[1]);
        if (outMonth == month) {
            return outDate;
        }
        return "0";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] date = in.split(" ");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int week = Integer.parseInt(date[2]);
        int day = Integer.parseInt(date[3]);

        System.out.println(weekToDayFormat(year, month, week, day));
//        System.out.println(weekToDayFormat(2018, 02, 3, 1));
    }
}
