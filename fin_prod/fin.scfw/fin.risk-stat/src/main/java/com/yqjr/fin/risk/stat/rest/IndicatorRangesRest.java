package com.yqjr.fin.risk.stat.rest;

import java.util.*;

import com.yqjr.fin.risk.stat.common.ResultMsg;
import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;
import com.yqjr.scfw.common.results.ListResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

import com.yqjr.fin.risk.stat.common.JQGridJsonResult;
import com.yqjr.fin.risk.stat.entity.IndicatorRanges;
import com.yqjr.fin.risk.stat.condition.IndicatorRangesCondition;
import com.yqjr.fin.risk.stat.services.IndicatorRangesService;


@Api(consumes = "application/json",  produces = "application/json", protocols = "http", basePath = "indicatorRangess")
@RestController
@RequestMapping(value = "/indicatorRanges")
public class IndicatorRangesRest extends BaseRest<IndicatorRangesService, IndicatorRanges> {

    @Autowired
    private IndicatorRangesService indicatorRangesService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询预警信号表（参数：实体对象属性、pageNum、pageSize）", tags = "预警信号表信息：IndicatorRangesRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<IndicatorRanges> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            IndicatorRangesCondition condition) {

        List<IndicatorRanges> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<IndicatorRanges> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询预警信号表信息（参数：实体对象属性、pageNum、pageSize）", tags = "预警信号表信息：IndicatorRangesRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<IndicatorRanges> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sord", required = true) String sord,
            IndicatorRangesCondition condition) {
        List<IndicatorRanges> list = indicatorRangesService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<IndicatorRanges> pageList = new PageInfo<>(list);
        JQGridJsonResult<IndicatorRanges> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }
    /*
        预警信号灯体条件查询接口
     */
    @ApiOperation(value = "分页查询预警信号表信息（参数：实体对象属性、pageNum、pageSize）", tags = "预警信号表信息：IndicatorRangesRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selIndicatorRangesByPage", method = RequestMethod.GET)
    public JQGridJsonResult<IndicatorRanges> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            IndicatorsCondition condition) {
        List<IndicatorRanges> list=indicatorRangesService.selIndicatorRangesByPage(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<IndicatorRanges> pageList = new PageInfo<>(list);
        JQGridJsonResult<IndicatorRanges> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);
        return jqGridJson;
    }
    @ApiOperation(value = "新增指标预警信号（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/InsertIndicatorRangesRest", method = RequestMethod.POST)
    public ResultMsg<String> InsertIndicatorTypesRest(IndicatorRanges it) {
        try {
            baseService.insert(it);
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
        return new ResultMsg<String>(Const.CODE_SUCCESS, "添加成功", Const.SUCCESS, "");
    }
    @ApiOperation(value = "删除指标预警信号（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/DeleteIndicatorRangesRest", method = RequestMethod.GET)
    public ResultMsg<String> DeleteIndicatorRangesRest(String params) {
        String [] a1 = params.split(",");
        List<Long> sumid = new ArrayList<Long>();
        for(String str:a1) {
            long a = Long.parseLong(str);
            sumid.add(a);
        }
        try {
            baseService.deleteByIds(sumid);
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
        return new ResultMsg<String>(Const.CODE_SUCCESS, "删除成功", Const.SUCCESS, "");
    }

    @ApiOperation(value = "根据id修改指标预警信号（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/UpdateIndicatorRangesRest", method = RequestMethod.POST)
    public ResultMsg<String> UpdateIndicatorTypesRest(IndicatorRangesCondition it) {
        try {
            baseService.patchById(it);
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
        return new ResultMsg<String>(Const.CODE_SUCCESS, "修改成功", Const.SUCCESS, "");
    }
    @ApiOperation(value = "根据id查询指标预警信号", tags = "指标类型基础表信息：IndicatorRanges")
    @RequestMapping(value = "/SelectIndicatorRangesById", method = RequestMethod.GET)
    public ObjectResultResponse <IndicatorRanges> SelectIndicatorTypesRestById(IndicatorRangesCondition it) {
        IndicatorRanges it1 = baseService.selectById2(it);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_CHECK_SUCCESS, it1);

    }
    @ApiOperation(value = "下拉列表五项查询", tags = "指标类型基础表信息：IndicatorRanges")
    @RequestMapping(value = "/selIndicatorRangesFive", method = RequestMethod.POST)
    public List<IndicatorRanges> selIndicatorRangesFive() {
        List<IndicatorRanges> it = baseService.selIndicatorRangesFive();
        return it;
    }
    @ApiOperation(value = "下拉列表查询数据", tags = "指标类型基础表信息：IndicatorRanges")
    @RequestMapping(value = "/selMany", method = RequestMethod.POST)
    public Map<String,List<IndicatorRanges>> selMany(){
        Map<String,List<IndicatorRanges>> map=baseService.selMany();
        return map;
    }
}