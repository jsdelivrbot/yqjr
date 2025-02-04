package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.yqjr.fin.mkmm.sales.common.ExcelUtils;
import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.condition.ActiveMatchDetailVoCondition;
import com.yqjr.fin.mkmm.sales.entity.ActiveDealer;
import com.yqjr.fin.mkmm.sales.entity.ActiveMatchMain;
import com.yqjr.fin.mkmm.sales.entity.PlanTrack;
import com.yqjr.fin.mkmm.sales.vo.domin.ActiveMatchVo;
import com.yqjr.fin.mkmm.sales.vo.domin.PersonTeamVo;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import jxl.write.WriteException;
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
import com.yqjr.fin.mkmm.sales.entity.ActiveMatchDetail;
import com.yqjr.fin.mkmm.sales.condition.ActiveMatchDetailCondition;
import com.yqjr.fin.mkmm.sales.services.ActiveMatchDetailService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "activeMatchDetails")
@RestController
@RequestMapping(value = "/activeMatchDetails")
public class ActiveMatchDetailRest extends BaseRest<ActiveMatchDetailService, ActiveMatchDetail> {

    //region generated by CodeRobot
    @Autowired
    private ActiveMatchDetailService activeMatchDetailService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询活动匹配明细表（参数：实体对象属性、pageNum、pageSize）", tags = "活动匹配明细表信息：ActiveMatchDetailRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<ActiveMatchDetail> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            ActiveMatchDetailCondition condition) {

        List<ActiveMatchDetail> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<ActiveMatchDetail> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询活动匹配明细表信息（参数：实体对象属性、pageNum、pageSize）", tags = "活动匹配明细表信息：ActiveMatchDetailRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveMatchVo> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            ActiveMatchDetailVoCondition condition) {
//        List<ActiveMatchDetail> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        if ("00".equals(condition.getBrandsCode())){
            condition.setBrandsCode(null);
        }
        if ("00".equals(condition.getSeriesCode())){
            condition.setSeriesCode(null);
        }
        if ("00".equals(condition.getCarBrandType())){
            condition.setCarBrandType(null);
        }
        if (condition.getActiveCode() == null || "".equals(condition.getActiveCode())){
            return new JQGridJsonResult<ActiveMatchVo>();
        }
        List<ActiveMatchVo> activeMatchVos = activeMatchDetailService.queryActiveDetil(condition,PageBounds.of(pageNum, pageSize));
        PageInfo<ActiveMatchVo> pageList = new PageInfo<>(activeMatchVos);
        JQGridJsonResult<ActiveMatchVo> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(activeMatchVos);

        return jqGridJson;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion

    /**
     * 下载查询出的结果
     *
     * @param
     * @return
     */
    @ApiOperation(value = "下载活动业务明细", tags = "活动业务明细：ActiveMatchDetailRest")
    @RequestMapping(value = "/drownLoadDetail")
    @Transactional
    public void drownLoadDetail(@RequestParam(value = "activeCode", required = true) String activeCode,
                                 @RequestParam(value = "largeAreaName", required = false) String largeAreaName,
                                 @RequestParam(value = "distributorName", required = false) String distributorName,
                                 @RequestParam(value = "brandsCode", required = false) String brandsCode,
                                 @RequestParam(value = "seriesCode", required = false) String seriesCode,
                                 @RequestParam(value = "carBrandType", required = false) String carBrandType,
                                 HttpServletResponse response) throws IOException, WriteException {
//        String path = "fin.mkmm-sales/src/main/resources/excel/activeDetail.xls";
//        String name = "促销活动业务明细.xls";
        //转换字段
        ActiveMatchVo activeMatchVo = activeMatchDetailService.exchangeVo(activeCode, largeAreaName, distributorName, brandsCode, seriesCode, carBrandType);
        //生成excel
        activeMatchDetailService.drownLoadDetail(activeMatchVo,response);
        //下载excel
//        ExcelUtils.excelDownLoad(path, name, response);
    }

    /**
     * 费用--查活动明细
     * @param pageNum
     * @param pageSize
     * @param sord
     * @param condition
     * @return
     */
    @ApiOperation(value = "分页查询活动匹配明细表信息（参数：实体对象属性、pageNum、pageSize）", tags = "活动匹配明细表信息：ActiveMatchDetailRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqViewGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ActiveMatchDetail> pageByJqViewGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            ActiveMatchDetailCondition condition) {
//        UserContext userContext=SessionHolder.getUserContext();
//        String company = userContext.getComCode();//公司
//        condition.setCompany(company);
        List<ActiveMatchDetail> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<ActiveMatchDetail> pageList = new PageInfo<>(list);
        JQGridJsonResult<ActiveMatchDetail> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 费用--下载查询出的结果
     *
     * @param
     * @return
     */
    @ApiOperation(value = "下载活动业务明细", tags = "活动业务明细：ActiveMatchDetailRest")
    @RequestMapping(value = "/activeMatchDetail")
    @Transactional
    public void activeMatchDetail(@RequestParam(value = "businessCode", required = false) String activeCode,
                                HttpServletResponse response)  {
        UserContext userContext=SessionHolder.getUserContext();
        String company = userContext.getComCode();//公司
        try {
            activeMatchDetailService.selectActiveMatchByCode(activeCode,response,company);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

    }


}