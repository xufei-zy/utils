package com.xufei.utils;

import java.io.File;

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
	
	public static void deleteFiles(String path) {
		File file = new File(path);
		if(file.isFile()) {
			file.delete();
		}else if(file.isDirectory()){
			//获取目录下的所有文件包括目录
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				String path2 = file2.getPath();
				deleteFiles(path2);
			}
		}
	}
}
