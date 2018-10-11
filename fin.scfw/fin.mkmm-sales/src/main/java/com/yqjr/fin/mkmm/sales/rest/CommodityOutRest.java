package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityOutVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ListResultResponse;
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
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.entity.CommodityOut;
import com.yqjr.fin.mkmm.sales.condition.CommodityOutCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityOutService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityOuts")
@RestController
@RequestMapping(value = "/commodityOuts")
public class CommodityOutRest extends BaseRest<CommodityOutService, CommodityOut> {

    //region generated by CodeRobot
    @Autowired
    CommodityOutService commodityOutService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询物料推送表（参数：实体对象属性、pageNum、pageSize）", tags = "物料推送表信息：CommodityOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityOut> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityOutCondition condition) {

        List<CommodityOut> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityOut> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料推送表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料推送表信息：CommodityOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityOut> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityOutCondition condition) {
        List<CommodityOut> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityOut> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityOut> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 销管二期
     * 物料出库登记
     * create by lf
     * 2018/9/3
     * @param commodityOutVo
     * @return
     */
    @ApiOperation(value = "物料出库表信息", tags = "物料推送表信息：CommodityOutRest")
    @RequestMapping(value = "/outReview", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<CommodityOut> outReview(@RequestBody CommodityOutVo commodityOutVo) {
        try{
            //物料出库提交审核
            commodityOutService.outReview(commodityOutVo);
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,"物料出库审核提交成功",null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,e.getMessage(),null);
        }catch(Exception e){
            logger.error("系统错误", e);
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }

    /**
     * 销管二期开发
     * 出库记录导出
     * create by fannaian on 20180905
     * @return
     */
    @ApiOperation(value = "出库记录轨迹导出", tags = "物料基础表信息：CommodityOutRest")
    @RequestMapping(value = "/export")
    public void export(@RequestParam("commodityCode") String commodityCode,
                       @RequestParam("commodityTypeCode") String commodityTypeCode,
                       @RequestParam("projectCode") String projectCode,
                       @RequestParam("dealerName") String dealerName,
                       @RequestParam("areaCode") String areaCode,
                       HttpServletResponse response) {
        try {
            UserContext userContext = SessionHolder.getUserContext();
            CommodityOut commodityOut = new CommodityOut();
            commodityOut.setCommodityCode(commodityCode);
            commodityOut.setCommodityTypeCode(commodityTypeCode);
            commodityOut.setProjectCode(projectCode);
            commodityOut.setDealerName(dealerName);
            if ("".equals(areaCode)) {
                if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
                    commodityOut.setAreaCode(userContext.getAreaCode());
                } else {
                    commodityOut.setAreaCode("");
                }
            } else {
                commodityOut.setAreaCode(areaCode);
            }
            commodityOutService.export(commodityOut,response);
        } catch (IOException e) {
            logger.error("出库记录导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }


    /**
     * 销管系统二期开发
     * DSP投放物料查询
     * create by fannaian on 20180905
     * @param pageNum
     * @param pageSize
     * @param condition
     * @return
     */
    @ApiOperation(value = "DSP投放物料查询", tags = "物料推送表信息：CommodityOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryCommodityList", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityOut> queryCommodityList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityOutCondition condition) {

        List<CommodityOut> list = commodityOutService.selectCommodityList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityOut> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityOut> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 销管系统二期开发
     * DSP物料接收接口
     * create by fannaian on 20180905
     * @param commodityOut
     * @return
     */
    @ApiOperation(value = "DSP物料接收接口", tags = "物料推送表信息：CommodityOutRest")
    @RequestMapping(value = "/receiveCommodity", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse receiveCommodity(@RequestBody CommodityOut commodityOut) {
        try{
            commodityOutService.receiveCommodity(commodityOut);
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,"物料接收成功！",null);
        } catch (ValidationException ve) {
            logger.error("接收异常！", ve);
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,ve.getMessage(),null);
        } catch (Exception e) {
            logger.error("系统异常！", e);
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }

    }

    @ApiOperation(value = "分页模糊查询物料推送表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料推送表信息：CommodityOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGridList", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityOut> pageByJqGridList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityOutCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        if (!UserRoleHelp.isAdmin() && !UserRoleHelp.isMarketingManager() && !UserRoleHelp.isMarketingWorkers()) {
            condition.setAreaCode(userContext.getAreaCode());
        } else {
            if ("".equals(condition.getAreaCode()) || "00".equals(condition.getAreaCode())) {
                condition.setAreaCode("");
            }
        }
        List<CommodityOut> list = commodityOutService.selectCommodityOutList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityOut> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityOut> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期开发
     * 出库记录导出
     * create by lf
     * 20180914
     * @return
     */
    @ApiOperation(value = "出库记录导出", tags = "物料基础表信息：CommodityOutRest")
    @RequestMapping(value = "/exportOut")
    public void exportCommoOut(@RequestParam("commodityCode") String commodityCode,
                       @RequestParam("commodityTypeCode") String commodityTypeCode,
                       @RequestParam("projectCode") String projectCode,
                       @RequestParam("dealerName") String dealerName,
                       HttpServletResponse response) {
        try {
            CommodityOut commodityOut = new CommodityOut();
            commodityOut.setCommodityCode(commodityCode);
            commodityOut.setCommodityTypeCode(commodityTypeCode);
            commodityOut.setProjectCode(projectCode);
            commodityOut.setDealerName(dealerName);
            commodityOutService.exportCommoOut(commodityOut,response);
        } catch (IOException e) {
            logger.error("出库记录导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }


}