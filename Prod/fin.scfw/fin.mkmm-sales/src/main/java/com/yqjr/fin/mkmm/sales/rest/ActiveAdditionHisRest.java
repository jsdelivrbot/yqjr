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
import com.yqjr.fin.mkmm.sales.entity.ActiveAdditionHis;
import com.yqjr.fin.mkmm.sales.condition.ActiveAdditionHisCondition;
import com.yqjr.fin.mkmm.sales.services.ActiveAdditionHisService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "activeAdditionHiss")
@RestController
@RequestMapping(value = "/activeAdditionHiss")
public class ActiveAdditionHisRest extends BaseRest<ActiveAdditionHisService, ActiveAdditionHis> {

    //region generated by CodeRobot

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询附加贷轨迹表（参数：实体对象属性、pageNum、pageSize）", tags = "附加贷轨迹表信息：ActiveAdditionHisRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<ActiveAdditionHis> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            ActiveAdditionHisCondition condition) {

        List<ActiveAdditionHis> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<ActiveAdditionHis> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询附加贷轨迹表信息（参数：实体对象属性、pageNum、pageSize）", tags = "附加贷轨迹表信息：ActiveAdditionHisRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveAdditionHis> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
//            @RequestParam(value = "sord", required = true) String sord,
            ActiveAdditionHisCondition condition) {
        List<ActiveAdditionHis> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<ActiveAdditionHis> pageList = new PageInfo<>(list);
        JQGridJsonResult<ActiveAdditionHis> jqGridJson = new JQGridJsonResult<>();
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