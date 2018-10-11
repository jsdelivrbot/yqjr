package com.yqjr.scfw.common;

import com.yqjr.scfw.common.utils.DateUtils;

/**
 * User: Kyll
 * Date: 2017-12-07 20:45
 */
public class ServiceResponse {
	private String code;
	private String desc;
	private String message;
	private Object body;
	private String timestamp;

	private ServiceResponse() {
	}

	public static ServiceResponse create(String code) {
		return ServiceResponse.create(code, null, null, null);
	}

	public static ServiceResponse create(String code, String message, Object body) {
		return ServiceResponse.create(code, null, message, body);
	}

	public static ServiceResponse create(String code, Object body) {
		return ServiceResponse.create(code, null, null, body);
	}

	public static ServiceResponse create(String code, String desc, String message, Object body) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setCode(code);
		serviceResponse.setDesc(desc);
		serviceResponse.setMessage(message);
		serviceResponse.setBody(body);
		serviceResponse.setTimestamp(DateUtils.formatDatetime(DateUtils.now()));
		return serviceResponse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
