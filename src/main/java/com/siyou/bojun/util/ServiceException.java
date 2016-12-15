package com.siyou.bojun.util;
/**
 * 
 * @author 青山
 * @FileName ServiceException.java
 * @Date Oct 19, 2016
 * @Desc
 *
 */
public class ServiceException  extends Throwable{
 
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}
