package com.yqjr.fin.scfw.meta.rest;

import java.util.*;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.scfw.meta.entity.DictItem;
import com.yqjr.fin.scfw.meta.entity.User;
import com.yqjr.fin.scfw.meta.common.JQGridJsonResult;
import com.yqjr.fin.scfw.meta.condition.DictItemCondition;
import com.yqjr.fin.scfw.meta.services.DictItemService;


@Api(consumes = "application/json", produces = "application/json",  protocols = "http", basePath = "dictItems")
@RestController
@RequestMapping(value = "/dictItems")
public class DictItemRest extends BaseRest<DictItemService, DictItem> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询数据字典项表（参数：实体对象属性、pageNum、pageSize）", tags = "数据字典项表信息：DictItemRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<DictItem> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            DictItemCondition condition) {

        List<DictItem> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<DictItem> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询数据字典项表信息（参数：实体对象属性、pageNum、pageSize）", tags = "数据字典项表信息：DictItemRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<DictItem> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sord", required = true) String sord,
            DictItemCondition condition) {
        List<DictItem> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<DictItem> pageList = new PageInfo<>(list);
        JQGridJsonResult<DictItem> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


}