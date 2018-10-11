package com.yqjr.fin.risk.stat.rest;

import java.util.*;

import com.yqjr.fin.risk.stat.common.ResultMsg;
import com.yqjr.fin.risk.stat.services.IndicatorsService;
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
import com.yqjr.fin.risk.stat.entity.Indicators;
import com.yqjr.fin.risk.stat.condition.IndicatorsCondition;


@Api(consumes = "application/json",  produces = "application/json", protocols = "http", basePath = "indicatorss")
@RestController
@RequestMapping(value = "/indicators")
public class IndicatorsRest extends BaseRest<IndicatorsService, Indicators> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IndicatorsService indicatorsService;
    @ApiOperation(value = "分页查询指标定义表（参数：实体对象属性、pageNum、pageSize）", tags = "指标定义表信息：IndicatorsRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<Indicators> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            IndicatorsCondition condition) {

        List<Indicators> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<Indicators> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询指标定义表信息（参数：实体对象属性、pageNum、pageSize）", tags = "指标定义表信息：IndicatorsRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<Indicators> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sord", required = true) String sord,
            IndicatorsCondition condition) {
        List<Indicators> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<Indicators> pageList = new PageInfo<>(list);
        JQGridJsonResult<Indicators> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }
    @ApiOperation(value = "新增指标（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/InsertIndicatorsRest", method = RequestMethod.POST)
    public ResultMsg<String> InsertIndicatorTypesRest(Indicators it) {
        baseService.insert(it);
        return new ResultMsg<String>(Const.CODE_SUCCESS, "添加成功", Const.SUCCESS, "");
    }

    @ApiOperation(value = "删除指标（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/DeleteIndicatorsRest", method = RequestMethod.GET)
    public ResultMsg<String> DeleteIndicatorTypesRest(String params) {
        String [] a1 = params.split(",");
        List<Long> sumid = new ArrayList<Long>();
        for(String str:a1) {
            long a = Long.parseLong(str);
            sumid.add(a);
        }
        baseService.deleteByIds(sumid);
        return new ResultMsg<String>(Const.CODE_SUCCESS, "添加成功", Const.SUCCESS, "");
    }

    @ApiOperation(value = "根据id修改指标类型（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/UpdateIndicatorsRest", method = RequestMethod.POST)
    public ResultMsg<String> UpdateIndicatorTypesRest( @RequestBody IndicatorsCondition it) {
       // it.setModifier();
        it.setModifyTime(new Date());
        baseService.patchById(it);
        return  new ResultMsg<String>(Const.CODE_SUCCESS, "修改成功", Const.SUCCESS, "");
    }
    @RequestMapping(value = "/SelectIndicatorsById", method = RequestMethod.GET)
    public ObjectResultResponse <Indicators> SelectIndicatorTypesRestById(Indicators it) {
        Indicators it1 = baseService.selectById2(it);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_CHECK_SUCCESS, it1);

    }
    @ApiOperation(value = "分页查询指标类型基础表（参数：实体对象属性、pageNum、pageSize）", tags = "指标类型基础表信息：IndicatorsRest")

    @RequestMapping(value = "/selIndicatorsBypage", method = RequestMethod.GET)
    public JQGridJsonResult<Indicators> SelectIndicatorTypesRestByPage(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                                                       @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
                                                                       IndicatorsCondition condition) {
        List<Indicators> list  = indicatorsService.selectLikeByNameAndCode(condition,PageBounds.of(pageNum, pageSize));
        PageInfo<Indicators> pageList = new PageInfo<>(list);
        JQGridJsonResult<Indicators> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);
        return   jqGridJson;

    }

    @ApiOperation(value = "根据指标代码进行查询（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/selectByIndicatorcode", method = RequestMethod.GET)
    public JQGridJsonResult<Indicators> selectByIndicatorcode(Indicators it) {
        List<Indicators> list =  baseService.selectByIndicatorcode(it);
        PageInfo<Indicators> pageList = new PageInfo<>(list);
        JQGridJsonResult<Indicators> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRows(list);
        return   jqGridJson;
    }
    @ApiOperation(value = "查询指标Name（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selIName", method = RequestMethod.GET)
    public List<Indicators> selIName(Indicators it){
        List<Indicators> it2=baseService.selIName(it);
        return it2;
    }
    @ApiOperation(value = "查询指标代码（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selICode", method = RequestMethod.GET)
    public Indicators selICode(Indicators it){
        return baseService.selICode(it);
    }
    @ApiOperation(value = "查询指标等级（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selIndlevel", method = RequestMethod.POST)
    public List<Indicators> selIndlevel(){
        return  baseService.selIndlevel();
    }
    @ApiOperation(value = "根据指标名称进行模糊查询（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selectByIndicatorname", method = RequestMethod.GET)
    public List<Indicators> selectByIndicatorname(Indicators it){
        List<Indicators> it2= null;
        try {
            logger.info("进入根据指标名称进行模糊查询");
            it2 = baseService.selectByIndicatorname(it);
            logger.info("结束根据指标名称进行模糊查询");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据指标名称进行模糊查询错误",e);
        }
        return it2;
    }
    @ApiOperation(value = "查询根据指标代码（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selMycode", method = RequestMethod.GET)
    public ResultMsg<String> selMycode(String indicatorcode){
        logger.info("进入查询代码是否重复");
        boolean a = baseService.selMycode(indicatorcode);
        logger.info("结束查询代码是否重复");
        if(a==true) {
            return new ResultMsg<String>(Const.CODE_SUCCESS, "指标代码可用", Const.SUCCESS, "");
        }else {
            return new ResultMsg<String>(Const.CODE_FAILURE, "指标代码已存在", Const.FAILURE, "");
        }
    }
    @ApiOperation(value = "查询根据指标代码（参数：实体对象属性）", tags = "基础查：继承自BaseRest")
    @RequestMapping(value = "/selByUpd", method = RequestMethod.GET)
    public ResultMsg<String> selByUpd(Indicators it){
        logger.info("进入查询代码是否重复");
        boolean a = baseService.selByUpd(it);
        logger.info("结束查询代码是否重复");
        if(a==true) {
            return new ResultMsg<String>(Const.CODE_SUCCESS, "指标代码可用", Const.SUCCESS, "");
        }else {
            return new ResultMsg<String>(Const.CODE_FAILURE, "指标代码已存在", Const.FAILURE, "");
        }
    }
}