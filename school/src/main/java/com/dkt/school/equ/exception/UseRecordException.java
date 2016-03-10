package com.dkt.school.equ.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UseRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(UseRecordException.class);
	public UseRecordException() {
		super();
		logger.error("userecordexception：参数有错");
	}
	public UseRecordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public UseRecordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public UseRecordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UseRecordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	


}
