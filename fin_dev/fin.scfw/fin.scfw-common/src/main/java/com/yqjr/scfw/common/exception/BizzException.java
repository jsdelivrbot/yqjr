package com.yqjr.scfw.common.exception;

/**
 * User: Kyll
 * Date: 2018-01-03 10:49
 */
public class BizzException extends BaseException {
	public BizzException(String code, String message) {
		this(code, message, null, null);
	}

	public BizzException(String code, String message, Object data) {
		this(code, message, data, null);
	}

	public BizzException(String code, String message, Throwable throwable) {
		this(code, message, null, throwable);
	}

	public BizzException(String code, String message, Object data, Throwable throwable) {
		super(code, message, data, throwable);
	}
}
