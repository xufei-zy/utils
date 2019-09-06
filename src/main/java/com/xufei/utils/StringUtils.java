package com.xufei.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	/**
	 * 判断源字符串是否有值，空字符串也算没值
	 */
	public static boolean isNull(String str) {
		if(str!=null&&str.length()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断源字符串是否有值，空字符串和空格也算没值
	 */
	public static boolean isBlank(String str) {
		if(str!=null&&str.length()>0&&str.trim().length()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断源是否为手机号
	 */
	public static boolean isPhone(String str) {
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断源是否为邮箱
	 */
	public static boolean isEmail(String str) {
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+)@([a-z0-9A-Z]+\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否全是字符
	 */
	public static boolean isEnglish(String str) {
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取n位随机的英文字符串
	 */
	public static String getRandomStr(int length) {
		char[] arr= {
			'A','B','C','D','E',
			'F','G','H','I','J',
			'K','L','M','N','O',
			'P','Q','R','S','T',
			'U','V','W','X','Y','Z'	
		};
		int len=arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(len);
			int abs = Math.abs(nextInt);
			char c=arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	
	/**
	 * 获取n位随机的英文字符串和数字
	 */
	public static String getRandomStrAndNumber(int length) {
		char[] arr= {
			'A','B','C','D','E',
			'F','G','H','I','J',
			'K','L','M','N','O',
			'P','Q','R','S','T',
			'U','V','W','X','Y','Z',
			'0','1','2','3','4','5','6','7','8','9'
		};
		int len=arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(len);
			int abs = Math.abs(nextInt);
			char c=arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	
	/**
	 * 获取n位随机的中文字符串
	 */
	public static String getRandomChinese(int length) {
		int start = Integer.parseInt("4e00",16);
		int end = Integer.parseInt("9fa5",16);
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int code=random.nextInt(end-start+1)+start;
			String str = new String(new char[] {(char) code});
			buffer.append(str);
		}
		return buffer.toString();
		
	}
}
