package com.xufei.test;

import java.util.Random;

import org.junit.Test;

import com.xufei.utils.StringUtils;

public class StringUtilsTest {
	
	@Test
	public void testisNull() {
		//boolean null1 = StringUtils.isNull(" ");
		boolean null2 = StringUtils.isBlank(" ");
		System.out.println(null2);
	}
	
	@Test
	public void testPhone() {
		boolean phone = StringUtils.isPhone("17805277008");
		System.out.println(phone);
	}
	
	@Test
	public void testEmail() {
		boolean email = StringUtils.isEmail("943620382@qq.com");
		System.out.println(email);
	}
	
	@Test
	public void testEnglish() {
		boolean english = StringUtils.isEnglish("trjvifndf");
		System.out.println(english);
	}
	
	@Test
	public void testRandom() {
		//Random random = new Random();
		//int nextInt = random.nextInt(26);
		String randomStr = StringUtils.getRandomStr(6);
		System.out.println(randomStr);
	}
	@Test
	public void testRandomAndNumber() {
		//Random random = new Random();
		//int nextInt = random.nextInt(26);
		String randomStr = StringUtils.getRandomStrAndNumber(4);
		System.out.println(randomStr);
	}
	@Test
	public void testRandomChinese() {
		//Random random = new Random();
		//int nextInt = random.nextInt(26);
		String randomChinese = StringUtils.getRandomChinese(7);
		System.out.println(randomChinese);
	}
}