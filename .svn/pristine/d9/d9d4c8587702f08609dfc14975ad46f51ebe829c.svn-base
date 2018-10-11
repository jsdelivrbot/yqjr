package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.yqjr.fin.mkmm.sales.entity.CommodityBase;
import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
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
import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;
import com.yqjr.fin.mkmm.sales.condition.CommodityAcceptanceCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityAcceptanceService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityAcceptances")
@RestController
@RequestMapping(value = "/commodityAcceptances")
public class CommodityAcceptanceRest extends BaseRest<CommodityAcceptanceService, CommodityAcceptance> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CommodityAcceptanceService commodityAcceptanceService;


    @ApiOperation(value = "分页查询物料验收表（参数：实体对象属性、pageNum、pageSize）", tags = "物料验收表信息：CommodityAcceptanceRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityAcceptance> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityAcceptanceCondition condition) {

        List<CommodityAcceptance> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityAcceptance> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料验收表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料验收表信息：CommodityAcceptanceRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityAcceptance> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityAcceptanceCondition condition) {

        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        condition.setAreaCode(userContext.getAreaCode());
        List<CommodityAcceptance> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityAcceptance> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityAcceptance> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 销管二期开发
     * 物料验收
     * create by fannaian on 20180904
     * @param commodityAcceptances
     * @return
     */
    @ApiOperation(value = "物料验收（参数：实体对象属性）", tags = "物料验收表信息：CommodityAcceptanceRest")
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<CommodityAcceptance> receive(@RequestBody List<CommodityAcceptance> commodityAcceptances) {

        try {
            commodityAcceptanceService.receiveCommodity(commodityAcceptances);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, "物料入库成功！", null);
        } catch (ValidationException ve) {
            logger.error("入库失败", ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, "物料入库异常，请重新操作！", null);
        } catch (Exception e) {
            logger.error("系统异常", e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }
    }


    /**
     * 销管二期开发
     * 查询可入库物料
     * create by fannaian on 20180904
     * @return
     */
    @ApiOperation(value = "查询可入库物料（参数：实体对象属性）", tags = "物料验收表信息：CommodityAcceptanceRest")
    @RequestMapping(value = "/queryCommodity", method = RequestMethod.GET)
    public ListResultResponse<CommodityAcceptance> queryCommodityList() {
        CommodityAcceptanceCondition condition = new CommodityAcceptanceCondition();
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        condition.setAreaCode(userContext.getAreaCode());
        condition.setAcceptanceStatus("0");
        List<CommodityAcceptance> list = baseService.selectList(condition);

        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_CHECK_SUCCESS, list);

    }

    /**
     * 销管二期开发
     * 验收结果导出
     * create by fannaian on 20180904
     * @return
     */
    @ApiOperation(value = "验收结果导出", tags = "物料基础表信息：CommodityAcceptanceRest")
    @RequestMapping(value = "/export")
    public void export(@RequestParam("commodityCode") String commodityCode ,
                        @RequestParam("commodityTypeCode") String commodityTypeCode ,
                        @RequestParam("provideOrganization") String provideOrganization ,
                        HttpServletResponse response) {
        try {
            CommodityAcceptance commodityAcceptance = new CommodityAcceptance();
            commodityAcceptance.setCommodityCode(commodityCode);
            commodityAcceptance.setCommodityTypeCode(commodityTypeCode);
            commodityAcceptance.setProvideOrganization(provideOrganization);
            commodityAcceptanceService.export(commodityAcceptance,response);
        } catch (IOException e) {
            logger.error("验收结果导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }

    /**
     * 销管二期开发
     * 物料验收修改
     * create by fannaian on 20180906
     */
    @ApiOperation(value = "验收物料修改", tags = "物料基础表信息：CommodityAcceptanceRest")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ObjectResultResponse<CommodityAcceptance> updateAcceptance(@RequestBody CommodityAcceptance commodityAcceptance) {

        try{
            commodityAcceptanceService.updateAcceptance(commodityAcceptance);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
        } catch (ValidationException ve) {
            ve.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, ve.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }



    }

}