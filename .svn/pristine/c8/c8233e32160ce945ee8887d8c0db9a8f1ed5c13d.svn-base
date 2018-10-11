package com.yqjr.scfw.common.exception.handler;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.ResponseCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author quangz
 */
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleException(ValidationException validationException,
                                                  WebRequest request) throws Exception {
        ObjectResultResponse<List<ObjectError>> resultResponse = new ObjectResultResponse<>();
        resultResponse.setIsSuccess(Const.FAILURE);
        resultResponse.setCode(ResponseCode.ERROR.getCode());
        resultResponse.setMsg(ResponseCode.ERROR.getDesc());
        Throwable cause = validationException.getCause();
        if (cause instanceof BindException) {
            BindException bindException = (BindException) cause;

            List<ObjectError> errList = bindException.getAllErrors();

            resultResponse.setResult(errList);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        return handleExceptionInternal(validationException, resultResponse, headers
                , HttpStatus.BAD_REQUEST, request);
    }
}
