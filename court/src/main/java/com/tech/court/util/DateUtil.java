package com.tech.court.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

  /**
   * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
   *
   * @param date
   * @return
   */
  public static int getSeason(Date date) {

    int season = 0;

    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int month = c.get(Calendar.MONTH);
    switch (month) {
      case Calendar.JANUARY:
      case Calendar.FEBRUARY:
      case Calendar.MARCH:
        season = 1;
        break;
      case Calendar.APRIL:
      case Calendar.MAY:
      case Calendar.JUNE:
        season = 2;
        break;
      case Calendar.JULY:
      case Calendar.AUGUST:
      case Calendar.SEPTEMBER:
        season = 3;
        break;
      case Calendar.OCTOBER:
      case Calendar.NOVEMBER:
      case Calendar.DECEMBER:
        season = 4;
        break;
      default:
        break;
    }
    return season;
  }
}
