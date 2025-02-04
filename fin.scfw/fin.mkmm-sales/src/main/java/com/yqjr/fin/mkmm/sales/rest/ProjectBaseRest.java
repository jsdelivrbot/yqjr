package com.yqjr.fin.mkmm.sales.rest;

import java.util.*;
import javax.validation.Valid;
import javax.validation.ValidationException;

import com.yqjr.fin.mkmm.sales.entity.CommodityIn;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.fin.mkmm.sales.services.CommodityInService;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.apache.catalina.User;
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
import com.yqjr.fin.mkmm.sales.entity.ProjectBase;
import com.yqjr.fin.mkmm.sales.condition.ProjectBaseCondition;
import com.yqjr.fin.mkmm.sales.services.ProjectBaseService;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "projectBases")
@RestController
@RequestMapping(value = "/projectBases")
public class ProjectBaseRest extends BaseRest<ProjectBaseService, ProjectBase> {

    @Autowired
    ProjectBaseService projectBaseService;
    @Autowired
    CommodityInService commodityInService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询项目基础表（参数：实体对象属性、pageNum、pageSize）", tags = "项目基础表信息：ProjectBaseRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<ProjectBase> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            ProjectBaseCondition condition) {

        List<ProjectBase> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<ProjectBase> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询项目基础表信息（参数：实体对象属性、pageNum、pageSize）", tags = "项目基础表信息：ProjectBaseRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<ProjectBase> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            ProjectBaseCondition condition) {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        List<ProjectBase> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));

        PageInfo<ProjectBase> pageList = new PageInfo<>(list);
        JQGridJsonResult<ProjectBase> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    /**
     * 销管二期
     * 项目添加并校验名称是否重复
     * create by lf
     * 2018/9/3
     * @param condition
     * @return
     */
    @ApiOperation(value = "项目基础表添加信息（", tags = "项目基础表信息：ProjectBaseRest")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ObjectResultResponse<ProjectBase> insert(@RequestBody ProjectBase condition) {
        try{
            ProjectBase projectBase = new ProjectBase();
            UserContext userContext = SessionHolder.getUserContext();
            projectBase.setCompany(userContext.getComCode());
            projectBase.setProjectName(condition.getProjectName());
            ProjectBase projectBase1 = projectBaseService.selectByProjectName(projectBase);
            if(projectBase1 != null){
                return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,"该项目名已被占用",null);
            }
            //生成项目编码
            String projectCode = projectBaseService.makeProjectCode(userContext.getComCode());
            condition.setProjectCode(projectCode);
            condition.setCompany(userContext.getComCode());
            baseService.insert(condition);
            return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,Const.MSG_ADD_SUCCESS,null);
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,"操作失败",null);
        }catch(Exception e){
            logger.error("系统错误", e);
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }


    @ApiOperation(value = "项目删除", tags = "项目基础表删除信息：ProjectBaseRest")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ObjectResultResponse<ProjectBase> delete(@RequestParam(value = "id", required = true) Long id) {
        try{
            ProjectBase projectBase1 = projectBaseService.selectById(id);
            String projectCode = projectBase1.getProjectCode();
            ProjectBase projectBase = new ProjectBase();
            UserContext userContext = SessionHolder.getUserContext();
            projectBase.setCompany(userContext.getComCode());
            projectBase.setId(id);
            projectBase.setProjectCode(projectCode);
            List<CommodityIn> commodityIns = commodityInService.selectByProjectCode(projectCode);
            if(commodityIns.size() == 0){
                //将删除的数据插入轨迹表
                projectBaseService.insertToHis(id);
                baseService.delete(projectBase);
                return this.getObjectResultResponse(Const.SUCCESS,Const.CODE_SUCCESS,Const.MSG_DEL_SUCCESS,null);
            }else {
                return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,"该项目已经被使用，请勿删除",null);
            }
        }catch(ValidationException e){
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_SUCCESS,Const.MSG_DEL_FAILURES,null);
        }catch(Exception e){
            logger.error("系统错误", e);
            return this.getObjectResultResponse(Const.FAILURE,Const.CODE_FAILURE,Const.SYSTEM_ERROR,null);
        }
    }


    /**
     * 查询所有项目
     * @return
     */
    @ApiOperation(value = "查询所有项目", tags = "素材基础表信息：ProjectBaseRest")
    @RequestMapping(value = "/selectProjectBase", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<SelectCodeVo> selectProjectBaseAll() {

        List<SelectCodeVo> selectCodeVos = projectBaseService.selectProjectBaseAll();

        ListResultResponse<SelectCodeVo> listResult = new ListResultResponse<SelectCodeVo>();
        listResult.setResult(selectCodeVos);
        listResult.setCode("0000");
        listResult.setIsSuccess(true);
        listResult.setMsg("查询成功");

        return listResult;
    }

}