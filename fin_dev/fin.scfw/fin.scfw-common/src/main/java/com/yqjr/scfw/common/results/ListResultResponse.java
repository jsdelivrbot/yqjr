package com.yqjr.scfw.common.results;

import java.util.List;

import com.yqjr.scfw.common.Const;

public class ListResultResponse<T> extends BaseResultResponse{
	protected List<T> result;

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public static <T> ListResultResponse<T> createBySuccess(){
		ListResultResponse<T> resultResponse = new ListResultResponse<>();
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
        return resultResponse;
    }

    public static <T> ListResultResponse<T> createBySuccessMessage(String msg){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
        return resultResponse;
    }

    public static <T> ListResultResponse<T> createBySuccess(List<T> result){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setResult(result);
        return resultResponse;
    }

    public static <T> ListResultResponse<T> createBySuccess(String msg,List<T> result){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
		resultResponse.setResult(result);
        return resultResponse;
    }


    public static <T> ListResultResponse<T> createByError(){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(ResponseCode.ERROR.getDesc());
        return resultResponse;
    }


    public static <T> ListResultResponse<T> createByErrorMessage(String errorMessage){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }

    public static <T> ListResultResponse<T> createByErrorCodeMessage(String errorCode,String errorMessage){
    	ListResultResponse<T> resultResponse = new ListResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(errorCode);
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }
	
}
