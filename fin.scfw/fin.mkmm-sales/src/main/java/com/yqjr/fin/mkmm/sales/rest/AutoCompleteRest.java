package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.condition.AuDealerCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.AutoCompleteVo;
import com.yqjr.fin.mkmm.sales.services.AutoCompleteService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动补全服务类
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "autoCompleteRest")
@RestController
@RequestMapping(value = "/autoComplete")
public class AutoCompleteRest {
    @Autowired
    private AutoCompleteService autoCompleteService;

    @ApiOperation(value = "自动补全服务类", tags = "自动补全服务类根据CodeType查询相应的数据")
    @ApiImplicitParam(name = "codeType", value = "查询类型", required = true, dataType = "String")
    @RequestMapping(value = "/{codeType}", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<AutoCompleteVo> autoComplete(@PathVariable(value = "codeType", required = true) String codeType,
                                                           @RequestParam(value = "name") String name) {
        List<AutoCompleteVo> autoCompleteVos=autoCompleteService.autoComplete(codeType,name);
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, autoCompleteVos);

    }
    private ListResultResponse<AutoCompleteVo> getListResultResponse(boolean isSuccess, String code, String msg, List<AutoCompleteVo> list) {
        ListResultResponse<AutoCompleteVo> result = new ListResultResponse<AutoCompleteVo>();
        result.setResult(list);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
