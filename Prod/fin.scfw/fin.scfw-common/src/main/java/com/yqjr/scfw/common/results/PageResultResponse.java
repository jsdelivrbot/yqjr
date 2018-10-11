package com.yqjr.scfw.common.results;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.model.pagination.PageInfo;

public class PageResultResponse<T> extends BaseResultResponse{
	
	protected PageInfo<T> pageResult;

	public PageInfo<T> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageInfo<T> pageResult) {
		this.pageResult = pageResult;
	}
	
	public static <T> PageResultResponse<T> createBySuccess(){
		PageResultResponse<T> resultResponse = new PageResultResponse<>();
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
        return resultResponse;
    }

    public static <T> PageResultResponse<T> createBySuccessMessage(String msg){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
        return resultResponse;
    }

    public static <T> PageResultResponse<T> createBySuccess(PageInfo<T> result){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setPageResult(result);
        return resultResponse;
    }

    public static <T> PageResultResponse<T> createBySuccess(String msg,PageInfo<T> result){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		resultResponse.setMsg(msg);
		resultResponse.setPageResult(result);
        return resultResponse;
    }


    public static <T> PageResultResponse<T> createByError(){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(ResponseCode.ERROR.getDesc());
        return resultResponse;
    }


    public static <T> PageResultResponse<T> createByErrorMessage(String errorMessage){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(ResponseCode.ERROR.getCode());
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }

    public static <T> PageResultResponse<T> createByErrorCodeMessage(String errorCode,String errorMessage){
    	PageResultResponse<T> resultResponse = new PageResultResponse<>();
    	resultResponse.setIsSuccess(Const.FAILURE);
		resultResponse.setCode(errorCode);
		resultResponse.setMsg(errorMessage);
        return resultResponse;
    }
	
}
