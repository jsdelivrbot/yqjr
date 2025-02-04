package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;
import javax.validation.Valid;
import javax.validation.ValidationException;

import com.yqjr.fin.mkmm.sales.rest.vo.AreaMsgVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.results.ListResultResponse;
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
import com.yqjr.fin.mkmm.sales.entity.DealerArea;
import com.yqjr.fin.mkmm.sales.condition.DealerAreaCondition;
import com.yqjr.fin.mkmm.sales.services.DealerAreaService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "dealerAreas")
@RestController
@RequestMapping(value = "/dealerAreas")
public class DealerAreaRest extends BaseRest<DealerAreaService, DealerArea> {


    @Autowired
    DealerAreaService dealerAreaService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询经销商区域配置表（参数：实体对象属性、pageNum、pageSize）", tags = "经销商区域配置表信息：DealerAreaRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<DealerArea> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            DealerAreaCondition condition) {

        List<DealerArea> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<DealerArea> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询经销商区域配置表信息（参数：实体对象属性、pageNum、pageSize）", tags = "经销商区域配置表信息：DealerAreaRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<DealerArea> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            DealerAreaCondition condition) {
        List<DealerArea> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<DealerArea> pageList = new PageInfo<>(list);
        JQGridJsonResult<DealerArea> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }

    /**
     * 销管二期
     * 经销商品牌获取转换接口
     * create by lf
     * 2018/9/5
     * @return
     */
    @ApiOperation(value = "经销商品牌获取转换接口", tags = "经销商区域配置表信息：DealerAreaRest")
    @RequestMapping(value = "/traverseInformation")
    public ObjectResultResponse traverseInformation() {
        try{
            dealerAreaService.traverseInformation();
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,"数据成功导入本系统",null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,"操作失败",null);
        }catch(Exception e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }

    /**
     * 销管二期
     * 经销商品牌数据清除接口
     * create by lf
     * 2018/9/5
     * @return
     */
    @ApiOperation(value = "经销商品牌数据清除接口", tags = "经销商区域配置表信息：DealerAreaRest")
    @RequestMapping(value = "/cleanTable")
    public ObjectResultResponse cleanTable() {
        try{
            dealerAreaService.cleanTable();
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,"数据已经成功清除",null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,"操作失败",null);
        }catch(Exception e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }

    /**
     * 销管二期
     * 查询经销商区域信息
     * create by lf
     * 2018/9/8
     * @param
     * @return
     */
    @ApiOperation(value = "查询区域经销商信息树", tags = "经销商区域配置表信息：DealerAreaRest")
    @RequestMapping(value = "/DealerAreaTree", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<AreaMsgVo> selectTreeMsg() {
        List<AreaMsgVo> selectMenuVos = dealerAreaService.selectTreeMsg();
        ListResultResponse listResultResponse = new ListResultResponse();
        listResultResponse.setResult(selectMenuVos);
        listResultResponse.setMsg("查询成功！");
        listResultResponse.setIsSuccess(true);
        listResultResponse.setCode("0000");
        return listResultResponse;
    }
    /**
     * 销管二期开发
     * 物料出库查询经销商
     * create by fannaian on 20180908
     */
    @ApiOperation(value = "查询经销商")
    @RequestMapping(value = "/selectDealerTree", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<SelectMenuVo> selectDealerTree() {
        List<SelectMenuVo> selectMenuVos = dealerAreaService.selectDealerTree();
        ListResultResponse<SelectMenuVo> selectMenuVoListResultResponse = new ListResultResponse<>();
        selectMenuVoListResultResponse.setResult(selectMenuVos);
        selectMenuVoListResultResponse.setCode("0000");
        selectMenuVoListResultResponse.setIsSuccess(true);
        selectMenuVoListResultResponse.setMsg("查询成功");
        return selectMenuVoListResultResponse;
    }

    /**
     * 销管二期开发
     * 区域经销商查询
     * create by lf
     * 20180908
     */
    @ApiOperation(value = "查询经销商")
    @RequestMapping(value = "/selectDealerByCode", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<SelectMenuVo> selectDealerByCode(@RequestParam("code") String code) {
        List<SelectMenuVo> selectMenuVos = dealerAreaService.selectDealerByCode(code);
        ListResultResponse<SelectMenuVo> selectMenuVoListResultResponse = new ListResultResponse<>();
        selectMenuVoListResultResponse.setResult(selectMenuVos);
        selectMenuVoListResultResponse.setCode("0000");
        selectMenuVoListResultResponse.setIsSuccess(true);
        selectMenuVoListResultResponse.setMsg("查询成功");
        return selectMenuVoListResultResponse;
    }
}