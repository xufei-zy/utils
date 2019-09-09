package com.xufei.test;

import org.junit.Test;

import com.xufei.utils.FileUtils;

public class FileUtilsTest {

	@Test
	public void testFile() {
		String suffixName = FileUtils.getSuffixName("C:\\Dell\\UW.cmd");
		System.out.println(suffixName);
	}
	
	@Test
	public void testdeleteFiles() {
		String homeDirectory = FileUtils.getHomeDirectory();
		String workDirectory = FileUtils.getWorkDirectory();
		System.out.println(homeDirectory);
		System.out.println(workDirectory);
	}
}
