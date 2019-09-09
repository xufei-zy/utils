package com.xufei.utils;

import java.io.File;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class FileUtils {

	/**
	 * 获取文件扩展名  后缀名
	 * @return
	 */
	public static String getSuffixName(String path) {
		File file = new File(path);
		boolean file2 = file.isFile();
		if(file2) {
			int indexOf = path.indexOf(".");
			String substring = path.substring(indexOf, path.length());
			return substring;
		}else {
			return "该路径错误或不是普通文件";
		}
	}
	
	/**
	 * 删除文件
	 * @param path
	 */
	public static void deleteFiles(String path) {
		File file = new File(path);
		if(file.isFile()) {
			file.delete();
		}else if(file.isDirectory()){
			//获取目录下的所有文件包括目录
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				String path2 = file2.getPath();
				//递归删除文件
				deleteFiles(path2);
			}
		}
		//删除文件夹
		file.delete();
	}
	
	/**
	 * 获取操作系统用户目录
	 * @return
	 */
	public static String getHomeDirectory() {
		String property = System.getProperty("user.home");
		return property;	
	}
	/**
	 * 获取操作系统用户目录
	 * @return
	 */
	public static String getWorkDirectory() {
		String property = System.getProperty("user.dir");
		return property;	
	}
	
	public static String getFilesSize(String path,char unit) {
		File file = new File(path);
		long length = file.length();
		long size =0;
		switch (unit) {
		case 'K':
			size=length/1024;
			break;
		case 'M':
			size=length/1024/1024;
			break;
		case 'G':
			size=length/1024/1024/1024;
			break;
		default:
			size=length;
			break;
		}
		NumberFormat format = NumberFormat.getNumberInstance();
		//保留两位小数
		format.setMaximumFractionDigits(4);
		//如果不需要四舍五入，可以使用RoundingMode.DOWN
		format.setRoundingMode(RoundingMode.UP);
		String format2 = format.format(size);
		return format2+unit;
		
	}
}
