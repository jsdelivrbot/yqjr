package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.condition.AreaMainCondition;
import com.yqjr.fin.mkmm.sales.entity.AreaMain;
import com.yqjr.fin.mkmm.sales.services.AreaMainService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.PageResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "areaMains")
@RestController
@RequestMapping(value = "/areaMains")
public class AreaMainRest extends BaseRest<AreaMainService, AreaMain> {

    //region generated by CodeRobot
    @Autowired
    private AreaMainService areaMainService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询区域配置表（参数：实体对象属性、pageNum、pageSize）", tags = "区域配置表信息：AreaMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<AreaMain> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            AreaMainCondition condition) {

        List<AreaMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<AreaMain> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询区域配置表信息（参数：实体对象属性、pageNum、pageSize）", tags = "区域配置表信息：AreaMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<AreaMain> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            AreaMainCondition condition) {
        List<AreaMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<AreaMain> pageList = new PageInfo<>(list);
        JQGridJsonResult<AreaMain> jqGridJson = new JQGridJsonResult<>();
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