package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;
import javax.validation.Valid;

import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.entity.CommodityStock;
import com.yqjr.fin.mkmm.sales.condition.CommodityStockCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityStockService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityStocks")
@RestController
@RequestMapping(value = "/commodityStocks")
public class CommodityStockRest extends BaseRest<CommodityStockService, CommodityStock> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询物料库存表（参数：实体对象属性、pageNum、pageSize）", tags = "物料库存表信息：CommodityStockRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityStock> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityStockCondition condition) {

        List<CommodityStock> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityStock> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料库存表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料库存表信息：CommodityStockRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityStock> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityStockCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
            condition.setAreaCode(userContext.getAreaCode());
        }
        List<CommodityStock> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityStock> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityStock> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


}