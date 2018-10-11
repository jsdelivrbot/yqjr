package com.yqjr.fin.mkmm.sales.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.entity.MaterialIn;
import com.yqjr.fin.mkmm.sales.rest.vo.*;
import com.yqjr.fin.mkmm.sales.services.MaterialDealerService;
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
import com.yqjr.fin.mkmm.sales.entity.MaterialOut;
import com.yqjr.fin.mkmm.sales.condition.MaterialOutCondition;
import com.yqjr.fin.mkmm.sales.services.MaterialOutService;

import javax.servlet.http.HttpServletResponse;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "materialOuts")
@RestController
@RequestMapping(value = "/materialOuts")
public class MaterialOutRest extends BaseRest<MaterialOutService, MaterialOut> {


    @Autowired
    MaterialDealerService materialDealerService;
    @Autowired
    MaterialOutService materialOutService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询素材推送表（参数：实体对象属性、pageNum、pageSize）", tags = "素材推送表信息：MaterialOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<MaterialOut> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            MaterialOutCondition condition) {

        List<MaterialOut> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<MaterialOut> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询素材推送表信息（参数：实体对象属性、pageNum、pageSize）", tags = "素材推送表信息：MaterialOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<MaterialOut> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            MaterialOutCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        List<MaterialOut> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<MaterialOut> pageList = new PageInfo<>(list);
        JQGridJsonResult<MaterialOut> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期
     * 推送信息保存
     * create by lf
     * 2018/9/4
     * @param condition
     * @return
     */
    @ApiOperation(value = "素材推送信息", tags = "素材推送表信息：MaterialOutRest")
    @RequestMapping(value = "/MaterialOutToSave", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse MaterialOutToSave(@RequestBody MaterialOutVo condition) {
        try{
            materialOutService.insertToMaterialOut(condition);
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,Const.MSG_ADD_SUCCESS,null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }

    /**
     * 销管二期
     * 素材推送信息详情查看
     * create by lf
     * 2018/9/4
     * @param id
     * @return
     */
    @ApiOperation(value = "素材推送信息", tags = "素材推送表信息：MaterialOutRest")
    @RequestMapping(value = "/selectOutMesById", method = RequestMethod.GET)
    public ResultMsg<MaterialOutVo> selectOutMesById(@RequestParam(value="id", required = true) Long id) {
        try{
            MaterialOutVo materialOutVo = materialOutService.selectOutMesById(id);
            return new ResultMsg<MaterialOutVo>(Const.CODE_SUCCESS,Const.MSG_CHECK_SUCCESS,Const.SUCCESS,materialOutVo);
        }catch(ValidationException e){
            e.printStackTrace();
            return new ResultMsg<MaterialOutVo>(Const.CODE_SUCCESS,"操作失败",Const.FAILURE,null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResultMsg<MaterialOutVo>(Const.CODE_FAILURE,Const.SYSTEM_ERROR,Const.FAILURE,null);
        }
    }


    /**
     * 素材库查询页面数据导出
     * @param
     * @param response
     */
    @ApiOperation(value = "素材推送列表页面信息导出", tags = "素材推送表信息：MaterialOutRest")
    @RequestMapping(value = "/exportList")
    public void exportList(
            @RequestParam("materialCode") String materialCode,
            @RequestParam("brandsCode") String brandsCode,
            @RequestParam("materialTheme") String materialTheme,
            @RequestParam("uploader") String uploader,
            @RequestParam("materialSource") String materialSource,
            @RequestParam("createTimeStart") String createTimeStart,
            @RequestParam("createTimeEnd") String createTimeEnd,
//            @RequestBody MaterialInVo condition,
            HttpServletResponse response) {
            try {
                MaterialInVo materialInVo = new MaterialInVo();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (!"".equals(createTimeStart) && createTimeStart !=null) {
                    Date start = sdf.parse(createTimeStart.toString());
                    materialInVo.setCreateTimeStart(start);
                }
                if (!"".equals(createTimeEnd) && createTimeEnd !=null) {
                    Date end = sdf.parse(createTimeEnd.toString());
                    materialInVo.setCreateTimeEnd(end);
                }
                materialInVo.setMaterialCode(materialCode);
                materialInVo.setBrandsCode(brandsCode);
                materialInVo.setMaterialTheme(materialTheme);
                materialInVo.setUploader(uploader);
                materialInVo.setMaterialSource(materialSource);
                materialOutService.exportList(materialInVo,response);
            }catch(ParseException px) {
                px.printStackTrace();
            }catch (IOException e) {
                logger.error("出库记录导出异常！", e);
            } catch (Exception e) {
                logger.error("系统异常！", e);
            }
    }


    /**
     * 推送记录查询页面
     * @param pageNum
     * @param pageSize
     * @param condition
     * @return
     */
    @ApiOperation(value = "分页查询推送记录信息", tags = "素材推送表信息：MaterialOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selectMsgByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<MaterialOutHisExport> selectMsgByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            MaterialOutCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        List<MaterialOutHisExport> list = materialOutService.selectMsg(condition,PageBounds.of(pageNum, pageSize));

        PageInfo<MaterialOutHisExport> pageList = new PageInfo<MaterialOutHisExport>(list);
        JQGridJsonResult<MaterialOutHisExport> jqGridJson = new JQGridJsonResult<MaterialOutHisExport>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 素材推送查看页面数据导出
     * @param
     * @param response
     */
    @ApiOperation(value = "素材推送列表页面信息导出", tags = "素材推送表信息：MaterialOutRest")
    @RequestMapping(value = "/exportView")
    @ResponseBody
    public void exportView(
                            @RequestParam("id") Long id,
                            HttpServletResponse response) {
        try {
                materialOutService.exportViewMsg(id,response);
        } catch (IOException e) {
            logger.error("出库记录导出异常！", e);
        } catch (Exception e) {
            logger.error("系统异常！", e);
        }
    }


    /**
     * 销管二期
     * 经销商数据查询接口
     * create by lf
     * 2018/9/4
     * @param
     * @return
     */
    @ApiOperation(value = "素材推送查询接口", tags = "素材接收信息：MaterialOutRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/queryMaterialList", method = RequestMethod.GET)
    public JQGridJsonResult<JxsSelectResult> selectOutMesForJxs(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            String dealerCode,
            String company) {
        JxsSelect jxsSelect = new JxsSelect();
        jxsSelect.setCompany(company);
        jxsSelect.setDealerCode(dealerCode);
        List<JxsSelectResult> jxsSelectResults = materialDealerService.selectMessage(jxsSelect,PageBounds.of(pageNum, pageSize));
        PageInfo<JxsSelectResult> pageList = new PageInfo<JxsSelectResult>(jxsSelectResults);
        JQGridJsonResult<JxsSelectResult> jqGridJson = new JQGridJsonResult<JxsSelectResult>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(jxsSelectResults);
        return jqGridJson;
    }

    /**
     * 销管二期
     * 经销商点击接收按钮修改状态
     * create by lf
     * 2018/9/4
     * @param id
     * @return
     */
    @ApiOperation(value = "素材接收反馈按钮", tags = "素材接收信息：MaterialOutRest")
    @RequestMapping(value = "/receiveMaterial", method = RequestMethod.GET)
    public ObjectResultResponse receiveButton(@RequestParam(value="id",required = true) Long id,
                                              String opinion) {
        try {
            materialDealerService.update(id,opinion);
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,Const.MSG_PUT_SUCCESS,null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }
}