
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.service.util
* @file StringUtil.java
* 
* @date 2014-2-19-下午3:18:01
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service.util;

import java.util.regex.Pattern;


/**
 * @project Twitter
 * @author Dayong.Shen
 * @class StringUtil
 * 
 * @date 2014-2-19-下午3:18:01
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */

public class StrUtil {

	/*
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/
	  public static boolean isInteger(String str) {  
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	    return pattern.matcher(str).matches();  
	  }

	  /* 
	   * 判断是否为浮点数，包括double和float 
	   * @param str 传入的字符串 
	   * @return 是浮点数返回true,否则返回false 
	 */  
	   public static boolean isDouble(String str) {  
	     Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");  
	     return pattern.matcher(str).matches();  
	   }

	
}
