package com.yqjr.scfw.common.validate;

import java.util.List;

/**
 * User: Kyll
 * Date: 2018-01-02 10:55
 */
public class ValidateResponse {
	private String message;
	private List<String> messageList;
	private String stackTrace;

	public ValidateResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
}
