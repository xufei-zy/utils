/**
 * 
 */
package com.xufei.utils;


/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2017年3月14日 上午10:12:31
 */
public class StringUtil {
	
	
	/**
	 * 限定StringUtil不可以new出对象，只能调用静态方法
	 */
	protected StringUtil(){}
	
	
	/**
	 * 
	 * 功能说明：判断字符串是否有值，空白字符串也不算<br>
	 * @param src
	 * @return
	 * boolean
	 */
	public static boolean hasLength(String src){
		return src != null && src.length() > 0;
	}
	
	
	/**
	 * 功能说明：判断字符串是否有值，空白字符串和空格也不算<br>
	 * @param src
	 * @return
	 * boolean
	 */
	public static boolean hasText(String src){
		return src != null && src.trim().length() > 0;
	}
	
	
	/**
	 * 功能说明：隐藏字符串中某些字符，
	 * 例如手机号码、用户名、用户姓名等敏感信息，13800138000→1380013****，王麻子→王** <br>
	 * @param src
	 * @param start
	 * @param end
	 * @return
	 * String
	 */
	public static String hidden(String src, int start, int end){
		if(src == null){
			return null;
		}
		char[] chs = src.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < chs.length; i++) {
			result.append(i >= start && i <= end ? '*' : chs[i]);
		}
		return result.toString();
	}
	
	/**
	 * 功能说明：判断字符串的值是不是数字<br>
	 * @param validString
	 * @return
	 * boolean
	 */
	public static boolean isNumber(String validString){
		if(!hasText(validString)){
			return false;
		}
		byte[] tempbyte = validString.getBytes();
		for(int i = 0; i < validString.length(); i++){
			if( ( tempbyte[i] == 45 ) && ( i == 0 ) ){
				continue;
			}
			if((tempbyte[i] < 48) || (tempbyte[i] > 57)){
				return false;
			}
		}
		return true;
	}
	/***
	 * 排除HTML相关的标签字符
	 * @param str
	 * @return
	 */
	public static String exculeHtml(String str) {
		String rep = str.replaceAll("<([^>]*)>", "");
		String replace = rep.replace("&nbsp;", "");
		return replace;
	}
	/***
	 *  世界互联网大会.txt
	 *  1.subString()  
	 *  2.indexOf()
	 *  3.spilt();
	 *  4.replace();
	 *  
	 * @param string
	 * @param sub
	 * @return
	 */
	public static String subStr(String string ,String sub) {
		String replace = string.replace(sub, "");
		return replace;
	}
	
	public static void main(String[] args) {
		/*System.out.println(hidden("中华人民共和国", 2, 5));
		
		String str = "<p>&nbsp; &nbsp;" + 
				" 氨基酸lsjfll进口量副经理就回家了" + 
				" 客户山东矿机风林火山<u>分类</u>号就开始发了<b>建行卡</b>" + 
				" &nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp; &nbsp;" + 
				" ljkjdf四方达四方达啊大锅饭费 <img >四方达根深蒂固</p>" + 
				" <p>&nbsp; &nbsp; 地方归属感十多个是<br></p>";*/
	/*	String replace = str.replace("<p>", "");
		String replace2 = replace.replace("&nbsp;", "");
		String replace3 = replace2.replace("<br>", "");
		String replace4 = replace3.replace("</p>", "");*/
		/*String rep = str.replaceAll("<([^>]*)>", "");
		String replace = rep.replace("&nbsp;", "");*/
		String subStr = StringUtil.subStr("世界互联网大会.txt", ".txt");
		System.out.println(subStr);
		
	}
}
