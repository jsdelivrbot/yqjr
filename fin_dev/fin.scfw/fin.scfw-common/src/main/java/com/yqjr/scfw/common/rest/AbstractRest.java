package com.yqjr.scfw.common.rest;

import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;

import java.util.List;

/**
 * @author quangz
 */
public abstract class AbstractRest {
    protected <ResultType> ObjectResultResponse<ResultType> getObjResultResponse(boolean isSuccess, String code, String msg, ResultType entity) {
        return makeObjectResultResponse(isSuccess, code, msg, entity);
    }

    protected <ResultType> ObjectResultResponse<ResultType> makeObjectResultResponse(boolean isSuccess, String code, String msg, ResultType entity) {
        ObjectResultResponse<ResultType> result = new ObjectResultResponse();
        result.setResult(entity);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected <ResultType> PageResultResponse<ResultType> makePageResultResponse(boolean isSuccess, String code, String msg, PageInfo<ResultType> pageInfo) {
        PageResultResponse<ResultType> result = new PageResultResponse();
        result.setPageResult(pageInfo);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected <ResultType> ListResultResponse<ResultType> makeListResultResponse(boolean isSuccess, String code, String msg, List<ResultType> list) {
        ListResultResponse<ResultType> result = new ListResultResponse();
        result.setResult(list);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
