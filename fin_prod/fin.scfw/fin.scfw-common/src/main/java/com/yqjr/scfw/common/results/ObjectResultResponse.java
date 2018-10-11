package com.yqjr.scfw.common.results;

import com.yqjr.scfw.common.Const;

public class ObjectResultResponse<T> extends BaseResultResponse{
	
	protected T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	public static <T> ObjectResultResponse<T> createBySuccess(){
		ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
        return resultResponse;
    }

    public static <T> ObjectResultResponse<T> createBySuccessMessage(String msg){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
        return resultResponse;
    }

    public static <T> ObjectResultResponse<T> createBySuccess(T result){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setResult(result);
        return resultResponse;
    }

    public static <T> ObjectResultResponse<T> createBySuccess(String msg,T result){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
		resultResponse.setResult(result);
        return resultResponse;
    }


    public static <T> ObjectResultResponse<T> createByError(){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(ResponseCode.ERROR.getDesc());
        return resultResponse;
    }


    public static <T> ObjectResultResponse<T> createByErrorMessage(String errorMessage){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }

    public static <T> ObjectResultResponse<T> createByErrorCodeMessage(String errorCode,String errorMessage){
    	ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(errorCode);
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }

	
}
