package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.TeamMainCondition;
import com.yqjr.fin.mkmm.sales.entity.TeamMain;
import com.yqjr.fin.mkmm.sales.services.TeamMainService;
import com.yqjr.fin.mkmm.sales.vo.domin.PersonTeamVo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "teamMains")
@RestController
@RequestMapping(value = "/teamMains")
public class TeamMainRest extends BaseRest<TeamMainService, TeamMain> {

    //region generated by CodeRobot

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TeamMainService teamMainService;

    @ApiOperation(value = "分页查询销售团队管理基本信息表（参数：实体对象属性、pageNum、pageSize）", tags = "销售团队管理基本信息表信息：TeamMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<TeamMain> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            TeamMainCondition condition) {

        List<TeamMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<TeamMain> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询销售团队管理基本信息表信息（参数：实体对象属性、pageNum、pageSize）", tags = "销售团队管理基本信息表信息：TeamMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<TeamMain> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            TeamMainCondition condition) {

        UserContext context =SessionHolder.getUserContext();
        condition.setCompany(context.getComCode());
        if (UserRoleHelp.isAdmin()||UserRoleHelp.isMarketingManager()||UserRoleHelp.isMarketingWorkers()){
            condition.setAreaCode(null);
        }else {
            condition.setAreaCode(context.getAreaCode());
        }
        List<TeamMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<TeamMain> pageList = new PageInfo<>(list);
        JQGridJsonResult<TeamMain> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    //模糊查询团队维护列表
    @ApiOperation(value = "分页查询销售团队管理基本信息表信息（参数：实体对象属性、pageNum、pageSize）", tags = "销售团队管理基本信息表信息：TeamMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGridWork", method = RequestMethod.GET)
    public JQGridJsonResult<TeamMain> pageByJqGridWork(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            TeamMainCondition condition) {
        UserContext context =SessionHolder.getUserContext();
        condition.setCompany(context.getComCode());
        if (UserRoleHelp.isSalesManager()||UserRoleHelp.isRegionalLeaders()){
            condition.setAreaCode(context.getAreaCode());
        }
        List<TeamMain> list = teamMainService.queryTeamMain(condition,PageBounds.of(pageNum,pageSize));
        PageInfo<TeamMain> pageList = new PageInfo<TeamMain>(list);
        JQGridJsonResult<TeamMain> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion

    //模糊查询综合信息查询列表
    @ApiOperation(value = "分页查询销售团队管理综合查询信息（参数：实体对象属性、pageNum、pageSize）", tags = "销售团队管理基本信息表信息：TeamMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGridAllList", method = RequestMethod.GET)
    public JQGridJsonResult<TeamMain> pageByJqGridAllList(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            TeamMainCondition condition) {
        /*******
         * 加入登录用户限制,区域，公司
         * **/
//        condition.setAreaCode(UserRoleHelp.getAreaCode());
//        condition.setCompany(UserRoleHelp.getCompanyCode());
        UserContext context =SessionHolder.getUserContext();
        condition.setCompany(context.getComCode());
        if (UserRoleHelp.isSalesManager()||UserRoleHelp.isRegionalLeaders()){
            condition.setAreaCode(context.getAreaCode());
        }
        List<TeamMain> list = teamMainService.queryAllListTeamMain(condition,PageBounds.of(pageNum,pageSize));
        PageInfo<TeamMain> pageList = new PageInfo<TeamMain>(list);
        JQGridJsonResult<TeamMain> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }




    //综合查询，团队下人员信息
    @ApiOperation(value = "根据reviewId查询历史记录", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/queryPerson", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<List<PersonTeamVo>> queryPersonByTeamCode(@RequestParam(value = "teamCode") String teamCode) {
        try{
            List<PersonTeamVo> personTeamVos= teamMainService.queryPersonByTeamCode(teamCode);
            return new ResultMsg<>( Const.CODE_SUCCESS, null ,Const.SUCCESS, personTeamVos);
        }catch (ValidationException e){
            e.printStackTrace();
            return new ResultMsg<List<PersonTeamVo>>( Const.CODE_FAILURE, "操作失败" ,Const.FAILURE, null);
        }catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<List<PersonTeamVo>>( Const.CODE_FAILURE, "操作失败" ,Const.FAILURE, null);
        }
    }
    @ApiOperation(value = "根据人员代码查询该人员是否存在", tags = "")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/checkExsit", method = RequestMethod.GET)
    public ResultMsg checkExsit(@RequestParam(value = "teamCode", required = false) String teamCode){
        boolean b = teamMainService.selectByCode(teamCode);
        if(b==true){
            return new ResultMsg(Const.MSG_CHECK_SUCCESS,Const.MSG_CHECK_SUCCESS,Const.SUCCESS,null);
        }
        return new ResultMsg(Const.MSG_CHECK_SUCCESS,Const.MSG_CHECK_SUCCESS,Const.FAILURE,null);
    }

    @ApiOperation(value = "根据团队名称检查团队是否存在", tags = "")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/checkTeamName", method = RequestMethod.GET)
    public ResultMsg checkTeamName(@RequestParam(value = "teamName", required = false) String teamName){
        boolean b = teamMainService.selectByTeamName(teamName);
        if(b==true){
            return new ResultMsg(Const.MSG_CHECK_SUCCESS,Const.MSG_CHECK_SUCCESS,Const.SUCCESS,null);
        }
        return new ResultMsg(Const.MSG_CHECK_SUCCESS,Const.MSG_CHECK_SUCCESS,Const.FAILURE,null);
    }

}