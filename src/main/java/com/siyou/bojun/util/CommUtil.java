package com.siyou.bojun.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author 青山
 * @FileName CommUtil.java
 * @Date Nov 8, 2016
 * @Desc
 *
 */
public class CommUtil {

	//2016-10-18 15:38:11
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getFormatDate(Date date){
		return format.format(date);
	}
}
