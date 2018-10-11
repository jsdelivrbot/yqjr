package com.yqjr.fin.scfw.meta.rest;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;

import com.yqjr.fin.scfw.meta.services.DictItemService;


@Api(consumes = "application/json", produces = "application/json",  protocols = "http", basePath = "dictItems")
@RestController
@RequestMapping(value = "/dictItem")
public class DictItemController extends BaseRest<DictItemService, DictItemDto> {
	
	@ApiOperation(value = "通过value，code，flag获取字典信息", tags = "字典信息")
	@RequestMapping(value = "/getDictItem", method = RequestMethod.GET)
	public ListResultResponse<DictItemDto> getDictItem(
			 @RequestParam(value="code", required=true ) String code,
			 @RequestParam(value="flag", required=true ) Integer flag,
			          @RequestParam(value="value", required=false) String value) {
		List<DictItemDto> list=null;
		if(flag!=1&&flag!=0) {

			return getListResultResponse(false, "2", "flag参数只能为0或者1", list);
		}
		list=baseService.getName(code,flag,value);
		return getListResultResponse(true,"1", "成功", list);
	}
	
	@ApiOperation(value = "通过value，code获取字典信息", tags = "字典信息")
	@RequestMapping(value = "/getDictItemList", method = RequestMethod.GET)
	public ListResultResponse<DictItemDto> getDictItemList(
			 @RequestParam(value="code", required=true ) String code,
			 @RequestParam(value="value", required=true ) String value
			) {
		if(StringUtils.isBlank(code)) {
			return getListResultResponse(false, "2", "flag参数只能为0或者1", null);
		}
		
		return getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, baseService.getNameByvalue(code,value));
	}

}