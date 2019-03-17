package com.itheima.test;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils是apache的commons-lang3包下的一个类
 * 		commons下基本都是工具类。
 * 		lang3就是apache针对lang包的工具类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月15日
 */
public class StringUtilsTest {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = "";
		String str3 = "    ";
		
		System.out.println(StringUtils.isEmpty(str1));
		System.out.println(StringUtils.isEmpty(str2));
		System.out.println(StringUtils.isEmpty(str3));
		System.out.println("-------------");
		System.out.println(StringUtils.isBlank(str1));
		System.out.println(StringUtils.isBlank(str2));
		System.out.println(StringUtils.isBlank(str3));
	}

}
