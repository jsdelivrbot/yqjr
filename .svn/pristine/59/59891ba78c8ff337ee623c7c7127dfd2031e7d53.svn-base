package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.util.*;
import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.CommodityInCondition;
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
import com.yqjr.fin.mkmm.sales.entity.CommodityStock;
import com.yqjr.fin.mkmm.sales.condition.CommodityStockCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityStockService;

import javax.servlet.http.HttpServletResponse;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityStocks")
@RestController
@RequestMapping(value = "/commodityStocks")
public class CommodityStockRest extends BaseRest<CommodityStockService, CommodityStock> {

    @Autowired
    CommodityStockService commodityStockService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询物料库存表（参数：实体对象属性、pageNum、pageSize）", tags = "物料库存表信息：CommodityStockRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityStock> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityStockCondition condition) {

        List<CommodityStock> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityStock> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料库存表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料库存表信息：CommodityStockRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityStock> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityStockCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        if ("".equals(condition.getAreaCode())) {
            if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
                condition.setAreaCode(userContext.getAreaCode());
            }
        }
        List<CommodityStock> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityStock> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityStock> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期开发
     * 出库记录导出
     * create by lf on
     * 20180913
     * @return
     */
    @ApiOperation(value = "出库记录导出", tags = "物料基础表信息：CommodityOutRest")
    @RequestMapping(value = "/export")
    public void export(@RequestParam("areaCode") String areaCode,
                       @RequestParam("commodityTypeCode") String commodityTypeCode,
                       @RequestParam("commodityCode") String commodityCode,
                       HttpServletResponse response) {
        try {
            UserContext userContext = SessionHolder.getUserContext();
            CommodityStockCondition commodityStockCondition = new CommodityStockCondition();
            commodityStockCondition.setCompany(userContext.getComCode());
            if ("".equals(areaCode)) {
                if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
                    commodityStockCondition.setAreaCode(userContext.getAreaCode());
                } else {
                    commodityStockCondition.setAreaCode("");
                }
            } else {
                commodityStockCondition.setAreaCode(areaCode);
            }
            commodityStockCondition.setCommodityTypeCode(commodityTypeCode);
            commodityStockCondition.setCommodityCode(commodityCode);
            commodityStockService.export(commodityStockCondition,response);
        } catch (IOException e) {
            logger.error("出库记录导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }

    /**
     * 展示物料库存数量
     * @param commodityTypeCode
     * @param commodityCode
     * @return
     */
    @ApiOperation(value = "展示物料库存数量", tags = "物料基础表信息：CommodityOutRest")
    @RequestMapping(value = "/calculateStock", method = RequestMethod.GET)
    public String calculateStock(@RequestParam("commodityTypeCode") String commodityTypeCode,
                                 @RequestParam("commodityCode") String commodityCode) {

        String nowStock = commodityStockService.calculateStock(commodityTypeCode, commodityCode);
        return nowStock;

    }

    /**
     * 库存管理，库存求和
     * create by fannaian on 20180917
     * @param commodityTypeCode
     * @param commodityCode
     * @return
     */
    @ApiOperation(value = "库存管理，库存求和", tags = "物料基础表信息：CommodityOutRest")
    @RequestMapping(value = "/sumStock", method = RequestMethod.GET)
    public String sumStock(@RequestParam("commodityTypeCode") String commodityTypeCode,
                           @RequestParam("areaCode") String areaCode,
                                 @RequestParam("commodityCode") String commodityCode) {

        String sumStock = commodityStockService.sumStock(commodityTypeCode, commodityCode, areaCode);
        return sumStock;

    }


}