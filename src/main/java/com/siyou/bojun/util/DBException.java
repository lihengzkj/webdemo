package com.siyou.bojun.util;
/**
 * 
 * @author 青山
 * @FileName DBException.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
public class DBException extends Throwable{
 
	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable cause) {
		super(cause); 
	}
	
	
}
