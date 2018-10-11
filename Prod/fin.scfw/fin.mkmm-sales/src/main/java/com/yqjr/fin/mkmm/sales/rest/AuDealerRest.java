package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.yqjr.fin.mkmm.sales.entity.AuDealer;
import com.yqjr.fin.mkmm.sales.condition.AuDealerCondition;
import com.yqjr.fin.mkmm.sales.services.AuDealerService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "auDealers")
@RestController
@RequestMapping(value = "/auDealers")
public class AuDealerRest extends BaseRest<AuDealerService, AuDealer> {

    //region generated by CodeRobot

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询经销商表（参数：实体对象属性、pageNum、pageSize）", tags = "经销商表信息：AuDealerRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<AuDealer> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            AuDealerCondition condition) {

        List<AuDealer> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<AuDealer> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询经销商表信息（参数：实体对象属性、pageNum、pageSize）", tags = "经销商表信息：AuDealerRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<AuDealer> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            AuDealerCondition condition) {
        List<AuDealer> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<AuDealer> pageList = new PageInfo<>(list);
        JQGridJsonResult<AuDealer> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}