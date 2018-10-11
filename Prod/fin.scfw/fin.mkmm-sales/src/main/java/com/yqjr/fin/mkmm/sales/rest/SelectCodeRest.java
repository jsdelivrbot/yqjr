package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.rest.vo.AutoCompleteVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectProductCodeVo;
import com.yqjr.fin.mkmm.sales.services.SelectCodeService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhouchong on 2018/5/29.
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "selectcode")
@RestController
@RequestMapping(value = "/selectCode")
public class SelectCodeRest {

    @Autowired
    private SelectCodeService selectCodeService;


    @ApiOperation(value = "Select下拉框数据", tags = "Select下拉框数据服务类根据CodeType查询相应的数据")
    @ApiImplicitParam(name = "codeType", value = "查询类型", required = true, dataType = "String")
    @RequestMapping(value = "/{codeType}", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<SelectCodeVo> autoComplete(@PathVariable(value = "codeType",required = true) String codeType,
                                                         @RequestParam(value = "isUpCode",required = true) String isUpCode,
                                                         @RequestParam(value = "upCode",required = false) String upCode
    ) {
        List<SelectCodeVo> selectCodeVos=selectCodeService.selectCode(codeType,isUpCode,upCode);
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, selectCodeVos);
    }

    private ListResultResponse<SelectCodeVo> getListResultResponse(boolean isSuccess, String code, String msg, List<SelectCodeVo> list) {
        ListResultResponse<SelectCodeVo> result = new ListResultResponse<SelectCodeVo>();
        result.setResult(list);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @ApiOperation(value = "字典表查询下拉框数据", tags = "字典表查询下拉框数据，按照类型分类")
    @RequestMapping(value = "/selectProductAll", method = RequestMethod.GET)
    @ResponseBody
    public ObjectResultResponse<SelectProductCodeVo> selectProductAll() {
        SelectProductCodeVo selectProductCodeVo = selectCodeService.selectProductCodes();
        ObjectResultResponse<SelectProductCodeVo> objectResult = new ObjectResultResponse<SelectProductCodeVo>();
        objectResult.setCode("0000");
        objectResult.setMsg("查询成功");
        objectResult.setIsSuccess(true);
        objectResult.setResult(selectProductCodeVo);
        return objectResult;
    }

    @ApiOperation(value = "翻译字典表Code", tags = "（微服务）翻译字典表Code")
    @RequestMapping(value = "/translateCode", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<SelectCodeVo> translateCode(@RequestParam(value = "codeType",required = true) String codeType,
                                                         @RequestParam(value = "codeCode",required = true) String codeCode) {
        List<SelectCodeVo> selectCodeVos=selectCodeService.translateCode(codeType,codeCode);
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, selectCodeVos);
    }
}
