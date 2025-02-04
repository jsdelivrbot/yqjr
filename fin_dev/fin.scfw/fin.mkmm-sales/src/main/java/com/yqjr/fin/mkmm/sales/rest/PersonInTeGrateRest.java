package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.EventTeamCondition;
import com.yqjr.fin.mkmm.sales.condition.PersonMainCondition;
import com.yqjr.fin.mkmm.sales.condition.PersonWorkCondition;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.model.PersonDetail;
import com.yqjr.fin.mkmm.sales.services.EventTeamService;
import com.yqjr.fin.mkmm.sales.services.PersonMainHisService;
import com.yqjr.fin.mkmm.sales.services.PersonMainService;
import com.yqjr.fin.mkmm.sales.services.PersonTeamReviewService;
import com.yqjr.fin.mkmm.sales.vo.domin.PersonMainVo;
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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 创建人：李明轩
 * 功能作用：销售人员综合信息查询
 * 所属页面：PersonInTeGrate
 * 创建时间：2018年6月23日
 */

@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "personInTeGrates")
@RestController
@RequestMapping(value = "/personInTeGrates")
public class PersonInTeGrateRest extends BaseRest<PersonMainService, PersonMain> {

    //region generated by CodeRobot

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonMainService personMainService;

    @Autowired
    private PersonTeamReviewService personTeamReviewService;

    @Autowired
    private EventTeamService eventTeamService;

    @Autowired
    private PersonMainHisService personMainHisService;

    @ApiOperation(value = "分页查询人员基本信息表（参数：实体对象属性、pageNum、pageSize）", tags = "人员基本信息表信息：PersonMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<PersonMain> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            PersonMainCondition condition) {

        List<PersonMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<PersonMain> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询人员基本信息表信息（参数：实体对象属性、pageNum、pageSize）", tags = "人员基本信息表信息：PersonMainRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<PersonMainVo> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            PersonWorkCondition condition) {


        /**
         * 加入登录用户限制,区域，公司
         *
         */

//        condition.setAreaCode(UserRoleHelp.getAreaCode());
//        condition.setCompany(UserRoleHelp.getCompanyCode());
        UserContext context =SessionHolder.getUserContext();
        condition.setCompany(context.getComCode());
        if (UserRoleHelp.isSalesManager()||UserRoleHelp.isRegionalLeaders()){
            condition.setAreaCode(context.getAreaCode());
        }
//        List<PersonMain> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        List<PersonMainVo> list = personMainService.getPersonMainList(condition, PageBounds.of(pageNo, pageSize));
        PageInfo<PersonMainVo> pageList = new PageInfo<>(list);
        JQGridJsonResult<PersonMainVo> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(list);

        return jqGridJson;
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /**
     * 人员变更基本信息查询列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/querypersonteamreview", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<List<PersonMainHis>> querypersonteamreview(HttpServletRequest request) {
        try {
            String personCode = request.getParameter("personCode");
            List<PersonMainHis> personTeamReviewList = personTeamReviewService.selectPersonTeamReviewByPersonCode(personCode);

            return new ResultMsg<List<PersonMainHis>>(Const.CODE_SUCCESS, null, Const.SUCCESS, personTeamReviewList);
        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResultMsg<List<PersonMainHis>>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<List<PersonMainHis>>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }


    /**
     * 人员基本信息变更明细列表
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询历史记录", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/personTeamHisQuery", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<PersonMainVo> personTeamHisQuery(@RequestParam(value = "id") Long id) {
        try {
            PersonMainVo PersonMainVo = personMainHisService.selectPersonMainById(id);
            return new ResultMsg<PersonMainVo>(Const.CODE_SUCCESS, null, Const.SUCCESS, PersonMainVo);
        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResultMsg<PersonMainVo>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<PersonMainVo>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }


    /**
     * 人员信息查询列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<PersonMainVo> edit(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            PersonMainVo personMainVo = personMainService.getPersonMainById(id);

            return new ResultMsg<PersonMainVo>(Const.CODE_SUCCESS, null, Const.SUCCESS, personMainVo);
        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResultMsg<PersonMainVo>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<PersonMainVo>(Const.CODE_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }


    /**
     * 重大事项信息查询列表
     * @param
     * @return
     */


    /**
     * 修改人员
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改记录（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg<PersonDetail> modify(@RequestBody PersonDetail personDetail, Errors errors) {
        try {
            personMainService.modifyPerson(personDetail);
            return new ResultMsg<PersonDetail>(Const.MSG_PUT_SUCCESS, Const.MSG_PUT_SUCCESS + "人员代码为" + personDetail.getPersonCode(), Const.SUCCESS, null);
        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResultMsg<PersonDetail>(Const.MSG_PUT_FAILURE, e.toString(), Const.FAILURE, null);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<PersonDetail>(Const.MSG_PUT_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }


    //endregion


} 