package com.yqjr.fin.risk.stat.rest;

import java.util.*;
import javax.validation.Valid;

import com.alibaba.fastjson.JSON;
import com.yqjr.fin.risk.stat.entity.Indicators;
import com.yqjr.fin.risk.stat.services.IndicatorsService;
import org.mapstruct.Mapper;
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
import com.yqjr.fin.risk.stat.common.*;
import com.yqjr.fin.risk.stat.common.JQGridJsonResult;
import com.yqjr.fin.risk.stat.entity.IndicatorTypes;
import com.yqjr.fin.risk.stat.condition.IndicatorTypesCondition;
import com.yqjr.fin.risk.stat.services.IndicatorTypesService;



@Api(consumes = "application/json",  produces = "application/json",  protocols = "http", basePath = "indicatorTypess")
@RestController
@RequestMapping(value = "/IndicatorTypesRest")
public class IndicatorTypesRest extends BaseRest<IndicatorTypesService, IndicatorTypes> {


    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public IndicatorsService indicatorsService;

    @ApiOperation(value = "分页查询指标类型基础表（参数：实体对象属性、pageNum、pageSize）", tags = "指标类型基础表信息：IndicatorTypesRest")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<IndicatorTypes> page(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            IndicatorTypesCondition condition) {

        List<IndicatorTypes> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<IndicatorTypes> p = new PageInfo<>(list);

        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询指标类型基础表信息（参数：实体对象属性、pageNum、pageSize）", tags = "指标类型基础表信息：IndicatorTypesRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<IndicatorTypes> pageByJqGrid(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,

            IndicatorTypesCondition condition) {
        List<IndicatorTypes> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<IndicatorTypes> pageList = new PageInfo<>(list);
        JQGridJsonResult<IndicatorTypes> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    @ApiOperation(value = "添加指标类型", tags = "用户信息：UserController")
    @RequestMapping(value = "/InsertIndicatorTypesRest", method = RequestMethod.GET)
    public ResultMsg<String> InsertIndicatorTypesRest(IndicatorTypes it) {
        try {
            baseService.insert(it);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "添加成功", Const.SUCCESS, "");
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }


    }

    @ApiOperation(value = "根据id删除指标类型", tags = "用户信息：UserController")
    @RequestMapping(value = "/DeleteIndicatorTypesRest", method = RequestMethod.GET)
    public ResultMsg<String> DeleteIndicatorTypesRest(IndicatorTypes it) {
        try {
            baseService.deleteById(it.getId());
            return new ResultMsg<String>(Const.CODE_SUCCESS, "删除成功", Const.SUCCESS, "");
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }

    }

    @ApiOperation(value = "根据id修改指标类型", tags = "用户信息：UserController")
    @RequestMapping(value = "/UpdateIndicatorTypesRest", method = RequestMethod.GET)
    public ResultMsg<String> UpdateIndicatorTypesRest(IndicatorTypes it) {
        try {
            baseService.updateById(it);
            return new ResultMsg<String>(Const.CODE_SUCCESS, "修改成功", Const.SUCCESS, "");
        } catch (Exception e) {
            return new ResultMsg<String>(Const.CODE_FAILURE, "出现错误", Const.FAILURE, "");
        }
    }

    @ApiOperation(value = "根据id查询指标类型", tags = "指标类型基础表信息：IndicatorTypesRest")

    @RequestMapping(value = "/SelectIndicatorTypesRestById", method = RequestMethod.GET)
    public JQGridJsonResult<IndicatorTypes> SelectIndicatorTypesRestById(IndicatorTypes it) {
        IndicatorTypes it1 = baseService.selectById(it.getId());
        List<IndicatorTypes> list = new ArrayList();
        list.add(it1);
        PageInfo<IndicatorTypes> pageList = new PageInfo<>(list);
        JQGridJsonResult<IndicatorTypes> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRows(list);
        return jqGridJson;

    }



    @ApiOperation(value = "根据code查询指标表有没有子类型并删除", tags = "指标类型基础表信息：IndicatorTypesRest")
    @RequestMapping(value = "/SelectTypecodByCode", method = RequestMethod.GET)
    public ResultMsg<String> SelectTypecodByCode(String idteam) {
        String[] a1 = idteam.split(",");
        ResultMsg<String> r = new ResultMsg<String>();
        try {
            int sum = 0;
            List<Integer> sumid = new ArrayList<Integer>();
            for (String str : a1) {
                int a = Integer.parseInt(str);
                IndicatorTypes indicatorTypes1 = baseService.selectById((long) a);
                Indicators indicators = new Indicators();
                indicators.setTypecode(indicatorTypes1.getCode());
                List<Indicators> list = indicatorsService.selelctBy(indicators);
                sum += list.size();
                if (list.size() == 0) {
                    sumid.add(a);
                }
            }
            if (sum > 0) {
                r.setCode(Const.CODE_SUCCESS);
                r.setMsg("删除失败,指标类型有子类，不能删除");
                r.setIsSuccess(Const.FAILURE);


            } else {
                for (Integer id : sumid)
                    baseService.deleteById((long) id);
                r.setCode(Const.CODE_SUCCESS);
                r.setMsg("删除成功");
                r.setIsSuccess(Const.SUCCESS);
            }
        } catch (Exception e) {
            r.setCode(Const.CODE_FAILURE);
            r.setMsg("出现错误");
            r.setIsSuccess(Const.FAILURE);
        }

        return r;
    }

    @ApiOperation(value = "查询指标类型", tags = "指标类型基础表信息：IndicatorTypesRest")
    @RequestMapping(value = "/selItypes", method = RequestMethod.GET)
    public List<IndicatorTypes> selItypes(){
        return baseService.selItypes();
    }

    @ApiOperation(value = "根据code,name模糊查询指标类型（参数：实体对象属性、pageNum、pageSize）", tags = "指标类型基础表信息：IndicatorTypesRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/SelectLikeByNameAndCode", method = RequestMethod.GET)
    public JQGridJsonResult<IndicatorTypes> SelectLikeByNameAndCode(
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            IndicatorTypesCondition condition) {
        List<IndicatorTypes> list = baseService.selectLikeByNameAndCode(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<IndicatorTypes> pageList = new PageInfo<>(list);
        JQGridJsonResult<IndicatorTypes> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;


    }
}