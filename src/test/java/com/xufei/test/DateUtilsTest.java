package com.xufei.test;

import org.junit.Test;

import com.xufei.utils.DateUtils;

public class DateUtilsTest {
	
	@Test
	public void testAge() {
		int age = DateUtils.getAge("1998-02-02");
		System.out.println(age);
	}
	
	@Test
	public void testDays() {
		int futureDays = DateUtils.getFutureDays("2019-10-01");
		System.out.println(futureDays);
	}
	
	@Test
	public void testDays1() {
		int futureDays = DateUtils.getPastDays("2016-03-05");
		System.out.println(futureDays);
	}
	
	
	@Test
	public void test() {
		/*Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
		System.out.println(year);
		System.out.println(month+1);
		System.out.println(dayOfWeek);*/
		boolean dayInWeek = DateUtils.isDayInWeek("2019-09-03");
		System.out.println(dayInWeek);
	}
	
	
}
