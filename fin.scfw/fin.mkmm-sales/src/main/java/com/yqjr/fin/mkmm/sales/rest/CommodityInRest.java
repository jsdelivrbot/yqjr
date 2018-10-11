package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.yqjr.fin.mkmm.sales.rest.vo.CommodityInVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.condition.CommodityInCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityInService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityIns")
@RestController
@RequestMapping(value = "/commodityIns")
public class CommodityInRest extends BaseRest<CommodityInService, CommodityIn> {



    @Autowired
    CommodityInService commodityInService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询物料入库表（参数：实体对象属性、pageNum、pageSize）", tags = "物料入库表信息：CommodityInRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityIn> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityInCondition condition) {

        List<CommodityIn> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityIn> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料入库表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料入库表信息：CommodityInRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityIn> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityInCondition condition) {

        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        condition.setAreaCode(userContext.getAreaCode());
        List<CommodityIn> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityIn> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityIn> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 物料出库物料名称模糊查询
     * @param commodityName
     * @return
     */
    @ApiOperation(value = "物料出库信息查询", tags = "物料出库信息查询：CommodityInRest")
    @RequestMapping(value = "/selectByCommodityName", method = RequestMethod.GET)
    public ListResultResponse selectByCommodityName(@RequestParam(value = "commodityName")String commodityName){
        try{
            List<CommodityIn> commodityIns = commodityInService.queryCommodityInList(commodityName);
            return this.getListResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,Const.MSG_CHECK_SUCCESS,commodityIns);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getListResultResponse(Const.FAILURE,Const.CODE_SUCCESS,"操作失败",null);
        }catch(Exception e){
            logger.error("系统错误", e);
            return this.getListResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }

    /**
     * 销管二期开发
     * 物料入库登记
     * create by fannaian on 20180904
     * @param commodityInVo
     * @return
     */
    @ApiOperation(value = "物料入库登记（参数：实体对象属性）", tags = "物料入库表信息：CommodityInRest")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ObjectResultResponse<CommodityIn> submit(@RequestBody CommodityInVo commodityInVo) {

        try{
            commodityInService.submit(commodityInVo);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, "物料入库审核提交成功！",null);
        } catch (ValidationException ve) {
            logger.error("登记失败！", ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, ve.getMessage(),null);
        } catch (Exception e) {
            logger.error("登记失败！", e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR,null);
        }

    }

    /**
     * 入库查询页面数据导出
     * @param response
     */
    @ApiOperation(value = "物料出库列表页面信息导出", tags = "物料出库列表页面信息导出：CommodityOutRest")
    @RequestMapping(value = "/exportList")
    public void exportList(@RequestParam("commodityCode") String commodityCode,
                           @RequestParam("commodityTypeCode") String commodityTypeCode,
                           @RequestParam("projectCode") String projectCode,
                           @RequestParam("provideOrganization") String provideOrganization,
                           HttpServletResponse response) {
        try {
            CommodityIn commodityIn = new CommodityIn();
            commodityIn.setCommodityCode(commodityCode);
            commodityIn.setCommodityTypeCode(commodityTypeCode);
            commodityIn.setProvideOrganization(provideOrganization);
            commodityIn.setProjectCode(projectCode);
            commodityInService.exportList(commodityIn,response);
        } catch (IOException e) {
            logger.error("入库记录导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }
}