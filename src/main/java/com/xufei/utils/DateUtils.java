package com.xufei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 获取年龄
	 * @param birth
	 * @return
	 */
	//日历对象 Calendar 日期对象 Date
	public static int getAge(Calendar birth) {
		/*Date date = new Date();
		Calendar now =Calendar.getInstance();
		now.setTime(date);*/
		Calendar now = formateDateToCalendar(new Date());
		//当前年份
		int day=now.get(Calendar.YEAR);
		//（过去）生日年份
		int past = birth.get(Calendar.YEAR);
		return day-past;
	}
	
	public static int getAge(Date birth) {
		Calendar now = formateDateToCalendar(new Date());
		//当前年份
		int day=now.get(Calendar.YEAR);
		//（过去）生日年份
		Calendar calendar = formateDateToCalendar(birth);
		int past = calendar.get(Calendar.YEAR);
		return day-past;
	}
	
	public static int getAge(String birth) {
		Calendar now = formateDateToCalendar(new Date());
		//当前年份
		int day=now.get(Calendar.YEAR);
		//（过去）生日年份
		Date date = formateStringToDate(birth);
		Calendar calendar = formateDateToCalendar(date);
		int past = calendar.get(Calendar.YEAR);
		return day-past;
	}
	
	public static Calendar formateDateToCalendar(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;	
	}
	
	public static Date formateStringToDate(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		try {
			date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int getFutureDays(String future) {
		Date date = new Date();
		long time = date.getTime();
		Date formateStringToDate = formateStringToDate(future);
		long time2 = formateStringToDate.getTime();
		long dt=time2- time;
		int day=(int) (dt/1000/60/60/24);
		return day;
	}
	
	public static int getPastDays(String future) {
		Date date = new Date();
		long time = date.getTime();
		Date formateStringToDate = formateStringToDate(future);
		long time2 = formateStringToDate.getTime();
		long dt=time-time2;
		int day=(int) (dt/1000/60/60/24);
		return day;
	}
	
	/**
	 * 判断给定日期是否是今天
	 * @param str
	 * @return
	 */
	public static boolean isToday(String str) {
		/*
		 * 获取当前日期的年月日
		 */
		/*Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.get(Calendar.YEAR);
		instance.get(Calendar.MONTH);
		instance.get(Calendar.DAY_OF_MONTH);*/
		int futureDays = getFutureDays(str);
		if(futureDays==0) {
			return true;
		}
		return false;
	}
	
	/*
	 * 判断当前给定的日期是否在本周之内
	 */
	public static boolean isDayInWeek(String date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		Date stringToDate = formateStringToDate(date);
		Calendar dateToCalendar = formateDateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
			return true;
		}
		
		return false;
	}
	
}
