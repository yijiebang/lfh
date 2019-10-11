package com.reinfo.ipoly.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private static final SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private static final SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private static final SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getYear() {
		return sdfYear.format(new Date());
	}

	public static String getDay() {
		return sdfDay.format(new Date());
	}

	public static String getDays() {
		return sdfDays.format(new Date());
	}

	public static String getTime() {
		return sdfTime.format(new Date());
	}

	public static boolean compareDate(String s, String e) {
		if ((fomatDate(s) == null) || (fomatDate(e) == null)) {
			return false;
		}
		return (fomatDate(s).getTime() >= fomatDate(e).getTime());
	}

	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa = 0L;
			int years = (int) ((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / 86400000L / 365L);
			return years;
		} catch (Exception e) {
		}
		return 0;
	}

	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0L;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / 86400000L;

		return day;
	}

	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance();
		canlendar.add(5, daysInt);
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance();
		canlendar.add(5, daysInt);
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 获取系统当前日期的前一天
	 * 
	 * @return
	 */
	public static String getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return sdfDay.format(calendar.getTime());
	}

	/**
	 * 获取系统当前日期的前两天
	 * 
	 * @return
	 */
	public static String getYesterday2() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		return sdfDay.format(calendar.getTime());
	}

	/**
	 * 获取系统当前日期的后第五天
	 * 
	 * @return
	 */
	public static String getFiveday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, +5);
		return sdfDay.format(calendar.getTime());
	}

	public static String getAferDay(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdfDay.parse(date));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return sdfDay.format(calendar.getTime());
	}

	public static String getAferDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return sdfDay.format(calendar.getTime());
	}

	/**
	 * 时间戳转换为Date
	 * 
	 * @param unix
	 * @return
	 */
	public static Date UnixToDate(String unix) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(unix);
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * String 转为时间戳
	 * 
	 * @param time
	 * @return
	 */
	public static String DateToUnix(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String time="1970-01-06 11:45:55";
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Long.toString(date.getTime());
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(getAferDay());
		// System.out.println(fomatDate(getYesterday()));
		// System.out.println(DateToUnix(getTime()));
		// System.out.println(UnixToDate("1473320400000"));

	}
}