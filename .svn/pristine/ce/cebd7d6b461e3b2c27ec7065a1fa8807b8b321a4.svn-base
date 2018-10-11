package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;

import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.rest.vo.CommodityReviewVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ListResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.yqjr.fin.mkmm.sales.entity.CommodityReview;
import com.yqjr.fin.mkmm.sales.condition.CommodityReviewCondition;
import com.yqjr.fin.mkmm.sales.services.CommodityReviewService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "commodityReviews")
@RestController
@RequestMapping(value = "/commodityReviews")
public class CommodityReviewRest extends BaseRest<CommodityReviewService, CommodityReview> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CommodityReviewService commodityReviewService;

    @ApiOperation(value = "分页查询物料审核表（参数：实体对象属性、pageNum、pageSize）", tags = "物料审核表信息：CommodityReviewRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<CommodityReview> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            CommodityReviewCondition condition) {

        List<CommodityReview> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<CommodityReview> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询物料入库审核表信息（参数：实体对象属性、pageNum、pageSize）", tags = "物料审核表信息：CommodityReviewRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityReview> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityReviewCondition condition) {

        List<CommodityReview> list = commodityReviewService.queryInReviewList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityReview> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityReview> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期需求开发
     * 物料入库审核
     * create by fannaian on 20180904
     * @param commodityReview
     * @return
     */
    @ApiOperation(value = "物料入库审核（参数：实体对象属性）", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/reviewIn", method = RequestMethod.POST)
    public ObjectResultResponse<CommodityReview> review(@RequestBody CommodityReview commodityReview) {
        try {
            commodityReviewService.review(commodityReview);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_REVIEW_SUCCESS, null);
        } catch (ValidationException ve) {
            logger.error("审核异常！", ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, Const.MSG_REVIEW_FAILURE, null);
        } catch (Exception e) {
            logger.error("系统异常！", e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }

    }

    /**
     * 销管二期需求开发
     * 查询物料审核驳回信息
     * create by fannaian on 20180904
     * @param condition
     * @return
     */
    @ApiOperation(value = "查询物料审核驳回信息", tags = "物料审核表信息：CommodityReviewRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryProcessList", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityReview> queryProcessList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityReviewCondition condition) {

        List<CommodityReview> list = commodityReviewService.queryProcessList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityReview> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityReview> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期需求开发
     * 物料入库审核进度处理
     * create by fannaian on 20180904
     *
     * @param commodityReview
     * @return
     */
    @ApiOperation(value = "物料入库审核进度处理", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/inProcess", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<CommodityReview> inProcess(@RequestBody CommodityReview commodityReview) {
        try {
            commodityReviewService.inProcess(commodityReview);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
        } catch (ValidationException ve) {
            logger.error("修改异常", ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, Const.MSG_PUT_FAILURE, null);
        } catch (Exception e) {
            logger.error("系统异常", e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }

    }

    /**
     * 点击审核
     *
     * @param commodityReview
     * @return
     */
    @ApiOperation(value = "物料出库审核", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/outProcess", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<CommodityReview> outProcess(@RequestBody CommodityReview commodityReview) {
        try {
            commodityReviewService.outReview(commodityReview);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_REVIEW_SUCCESS, null);
        } catch (ValidationException ve) {
            logger.error("审核失败",ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, Const.MSG_REVIEW_FAILURE, null);
        } catch (Exception e) {
            logger.error("系统异常",e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }
    }


    /**
     * 点击审核按钮带出数据
     *
     * @param batchCode
     * @return
     */
    @ApiOperation(value = "物料出库审核查询", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/selectMsg", method = RequestMethod.GET)
    public ResultMsg<CommodityReviewVo> selectMsg(@RequestParam("batchCode") String batchCode) {
        try {
            CommodityReviewVo commodityReviewVo = commodityReviewService.selectMsg(batchCode);
            return new ResultMsg<CommodityReviewVo>(Const.CODE_SUCCESS, Const.MSG_REVIEW_SUCCESS, Const.SUCCESS, commodityReviewVo);
        } catch (ValidationException ve) {
            return new ResultMsg<CommodityReviewVo>(Const.CODE_SUCCESS, Const.MSG_REVIEW_FAILURE, Const.FAILURE, null);
        } catch (Exception e) {
            return new ResultMsg<CommodityReviewVo>(Const.CODE_FAILURE, Const.SYSTEM_ERROR, Const.FAILURE, null);
        }
    }

    @ApiOperation(value = "物料审核进度修改", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/changeReview", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse changeReview(@RequestBody CommodityReview commodityReview) {
        try {
            commodityReviewService.reviewChange(commodityReview);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
        } catch (ValidationException ve) {
            logger.error("修改失败",ve);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_SUCCESS, ve.getMessage(), null);
        } catch (Exception e) {
            logger.error("系统异常",e);
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, Const.SYSTEM_ERROR, null);
        }
    }

    @ApiOperation(value = "查询物料审核进度处理信息", tags = "物料审核表信息：CommodityReviewRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryOutProcessList", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityReview> queryOutProcessList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityReviewCondition condition) {

        List<CommodityReview> list = commodityReviewService.queryOutProcessList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityReview> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityReview> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 物料审核根据id看名细
     * @param id
     * @return
     */
    @ApiOperation(value = "物料审核根据id看名细", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/selectReviewById", method = RequestMethod.GET)
    public ObjectResultResponse<CommodityReview> selectReviewById(@RequestParam("id") Long id) {

        CommodityReview commodityReview = baseService.selectById(id);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_CHECK_SUCCESS, commodityReview);
    }
    /**
     * 物料审核根据批次号查经销商
     * @param batchCode
     * @return
     */
    @ApiOperation(value = "物料审核根据批次号查经销商", tags = "物料审核表信息：CommodityReviewRest")
    @RequestMapping(value = "/selectReviewDealer", method = RequestMethod.GET)
    public ListResultResponse<SelectMenuVo> selectReviewDealer(@RequestParam("batchCode") String batchCode) {

        List<SelectMenuVo> selectMenuVos = commodityReviewService.selectReviewDealer(batchCode);

        ListResultResponse<SelectMenuVo> listResultResponse = new ListResultResponse();
        listResultResponse.setResult(selectMenuVos);
        listResultResponse.setMsg("查询成功");
        listResultResponse.setIsSuccess(true);
        listResultResponse.setCode("0000");
        return listResultResponse;
    }

    /**
     * 出库审核列表页
     * @param pageNum
     * @param pageSize
     * @param condition
     * @return
     */
    @ApiOperation(value = "出库审核列表页", tags = "物料审核表信息：CommodityReviewRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryOutReviewList", method = RequestMethod.GET)
    public JQGridJsonResult<CommodityReview> queryOutReviewList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            CommodityReviewCondition condition) {

        List<CommodityReview> list = commodityReviewService.queryOutReviewList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<CommodityReview> pageList = new PageInfo<>(list);
        JQGridJsonResult<CommodityReview> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


}