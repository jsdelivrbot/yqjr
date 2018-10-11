package com.yqjr.scfw.common.controller;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.validate.ValidateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Kyll
 * Date: 2018-01-04 15:16
 */
public class ScfwController {
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidateResponse handleException(Exception exception) {
		ValidateResponse validateResponse = new ValidateResponse();
		if (exception instanceof BindException) {
			BindException bindException = (BindException) exception;

			List<ObjectError> errList= bindException.getAllErrors();
			List<String> messageList = new ArrayList<>(errList.size());
			for (ObjectError objectError : errList) {
				messageList.add(objectError.getDefaultMessage());
			}

			validateResponse.setMessageList(messageList);
		} else if (exception instanceof ConstraintViolationException) {
			ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception;

			List<String> messageList = new ArrayList<>(constraintViolationException.getConstraintViolations().size());
			for (ConstraintViolation constraintViolation : constraintViolationException.getConstraintViolations()) {
				messageList.add(constraintViolation.getMessage());
			}

			validateResponse.setMessageList(messageList);
		} else {
			validateResponse.setMessage(exception.getMessage());

			StringBuilder stackTrace = new StringBuilder();
			for (StackTraceElement ste : exception.getStackTrace()) {
				stackTrace.append(null!=ste?ste.toString():"");
			}
			validateResponse.setStackTrace(stackTrace.toString() + "\r\n");
		}
		return validateResponse;
	}

	protected ObjectResultResponse<String> createSuccess() {
		ObjectResultResponse<String> resultResponse = new ObjectResultResponse<>();
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		return resultResponse;
	}

	protected <T> ObjectResultResponse<T> createGetSuccess(T result) {
		ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
		resultResponse.setResult(result);
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		return resultResponse;
	}
}
