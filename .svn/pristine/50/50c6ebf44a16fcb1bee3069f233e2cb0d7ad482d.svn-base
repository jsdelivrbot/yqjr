package com.yqjr.scfw.common.exception;

import com.yqjr.scfw.common.utils.JsonUtils;

/**
 * User: Kyll
 * Date: 2018-01-02 13:21
 */
public class BaseException extends Exception {
	private String code;
	private Object data;

	public BaseException(String code, String message, Object data, Throwable throwable) {
		super(code + " " + message + (data == null ? "" : " " + JsonUtils.objectToJson(data)), throwable);
		this.code = code;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
