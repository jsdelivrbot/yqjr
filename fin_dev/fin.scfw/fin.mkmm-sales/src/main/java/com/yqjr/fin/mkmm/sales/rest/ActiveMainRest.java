package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;

import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainAllListCondition;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainListCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.ActiveMainVo;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.PageResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.entity.ActiveMain;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainCondition;
import com.yqjr.fin.mkmm.sales.services.ActiveMainService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "activeMains")
@RestController
@RequestMapping(value = "/activeMains")
public class ActiveMainRest extends BaseRest<ActiveMainService, ActiveMain> {

    //region generated by CodeRobot

    @Autowired
    private ActiveMainService activeMainService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询活动主表（参数：实体对象属性、pageNum、pageSize）", tags = "活动主表信息：ActiveMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<ActiveMain> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            ActiveMainCondition condition) {

        List<ActiveMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<ActiveMain> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询活动主表信息（参数：实体对象属性、pageNum、pageSize）", tags = "活动主表信息：ActiveMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveMain> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
//            @RequestParam(value = "sord", required = true) String sord,
            ActiveMainCondition condition) {
        List<ActiveMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<ActiveMain> pageList = new PageInfo<>(list);
        JQGridJsonResult<ActiveMain> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @ApiOperation(value = "分页查询活动制定信息", tags = "活动制定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/mainActiveList", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveMainVo> mainActiveList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
//            @RequestParam(value = "sord", required = true) String sord,
            ActiveMainListCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());   //添加公司作为筛选条件
        if (UserRoleHelp.isAdmin()||UserRoleHelp.isMarketingWorkers()||UserRoleHelp.isMarketingManager()) {
            condition.setAreaCode(null);    //所有区域
        }else {
            condition.setAreaCode(userContext.getAreaCode());    //添加区域作为筛选条件
        }
        List<ActiveMainVo> list = activeMainService.selectMainActives(condition, PageBounds.of(pageNo, pageSize));
        PageInfo<ActiveMainVo> pageList = new PageInfo<>(list);
        JQGridJsonResult<ActiveMainVo> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);
        return jqGridJson;
    }

    //endregion

    @ApiOperation(value = "分页查询活动制定信息", tags = "活动制定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/mainAllActiveList", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveMainVo> mainAllActiveList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
//            @RequestParam(value = "sord", required = true) String sord,
            ActiveMainAllListCondition condition) {

        if ("00".equals(condition.getBrandsCode())){
            condition.setBrandsCode(null);
        }

        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());   //添加公司作为筛选条件
        if (UserRoleHelp.isAdmin()||UserRoleHelp.isMarketingWorkers()||UserRoleHelp.isMarketingManager()) {
            condition.setAreaCode(null);    //所有区域
        }else {
            condition.setAreaCode(userContext.getAreaCode());    //添加区域作为筛选条件
        }
        List<ActiveMainVo> list = activeMainService.selectMainAllActives(condition, PageBounds.of(pageNo, pageSize));
        PageInfo<ActiveMainVo> pageList = new PageInfo<>(list);
        JQGridJsonResult<ActiveMainVo> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);
        return jqGridJson;
    }

}