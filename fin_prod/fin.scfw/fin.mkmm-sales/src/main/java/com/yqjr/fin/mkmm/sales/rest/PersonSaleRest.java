package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.JQGridJsonResult;
import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.common.UserRoleHelp;
import com.yqjr.fin.mkmm.sales.condition.PersonSaleCondition;
import com.yqjr.fin.mkmm.sales.entity.PersonSale;
import com.yqjr.fin.mkmm.sales.entity.PersonTeam;
import com.yqjr.fin.mkmm.sales.services.PersonSaleService;
import com.yqjr.fin.mkmm.sales.services.PersonTeamService;
import com.yqjr.fin.mkmm.sales.vo.domin.PersonTrackVo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ObjectResultResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;


@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "personSales")
@RestController
@RequestMapping(value = "/personSales")
public class PersonSaleRest extends BaseRest<PersonSaleService, PersonSale> {

    //region generated by CodeRobot
    @Autowired
    private PersonSaleService personSaleService;

    @Autowired
    private PersonTeamService personTeamService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "分页查询人员实际销售累计表（参数：实体对象属性、pageNum、pageSize）", tags = "人员实际销售累计表信息：PersonSaleRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageResultResponse<PersonSale> page(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            PersonSaleCondition condition) {

        List<PersonSale> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        PageInfo<PersonSale> p = new PageInfo<>(list);
        return this.getPageResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, p);

    }

    @ApiOperation(value = "分页查询人员实际销售累计表信息（参数：实体对象属性、pageNum、pageSize）", tags = "人员实际销售累计表信息：PersonSaleRest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/pageByJqGrid", method = RequestMethod.GET)
    public JQGridJsonResult<PersonTrackVo> pageByJqGrid(
            @RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize,
            //@RequestParam(value = "sord", required = true) String sord,
            PersonSaleCondition condition) throws ParseException {
//        List<PersonSale> list = baseService.selectList(condition, PageBounds.of(pageNum, pageSize));
        List<PersonTrackVo> vo = personSaleService.sumNumber(condition);
        PageInfo<PersonTrackVo> pageList = new PageInfo<>(vo);
        JQGridJsonResult<PersonTrackVo> jqGridJson = new JQGridJsonResult<>();
        jqGridJson.setPage(pageList.getPageNum());
        jqGridJson.setTotal(pageList.getPages());
        jqGridJson.setRecords(pageList.getTotal());
        jqGridJson.setRows(vo);

        return jqGridJson;
    }




    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion

    //查询人姓名
    @RequestMapping(value="/qryPerson")
    public String qryPersonByCode(@RequestParam(value = "personCode", required = false) String personCode) {
//        //校验只能查询登录人区域下的人员计划
//        PersonTeam personTeam = personTeamService.selectByPersonCode(personCode);
//        UserContext userContext = SessionHolder.getUserContext();
//        String areaCode = userContext.getAreaCode();
//        String companyCode = userContext.getComCode();
//        if (personTeam!=null&&areaCode.equals(personTeam.getAreaCode()) && companyCode.equals(personTeam.getCompany())) {
//                String personName = personSaleService.qryPersonByCode(personCode);
//                return personName;
//        } else {
//            return "1";
//        }
        if(null != personCode && !"".equals(personCode.trim())){
            String personName = personSaleService.qryPersonByCode(personCode);
            return personName;
        } else {
            return "";
        }
    }
    //人员预算任务及重大事件导出
    @RequestMapping(value = "personSaleExport")
    public void personSaleExport(PersonSaleCondition condition, HttpServletResponse response){
        try {
        personSaleService.personSaleExport(condition,response);
        } catch (ValidationException e) {
            logger.error("导出异常！", e);
            e.printStackTrace();
        }catch (Exception e) {
            logger.error("导出异常！", e);
        }
    }

    /**
     * 人员计划跟踪查询，判断人员是否存在
     * create by fanna on 20180627
     * @param personCode
     * @return
     */
    @RequestMapping(value="/queryPersonExitByCode")
    public ResultMsg queryPersonExitByCode(@RequestParam(value = "personCode", required = false) String personCode ) {
        if(!"".equals(personCode.trim()) || null != personCode) {
            try{
                personSaleService.queryPersonExitByCode(personCode);
                return new ResultMsg(Const.MSG_CHECK_SUCCESS, Const.CODE_SUCCESS,Const.SUCCESS ,null);
            } catch (ValidationException e) {
                e.printStackTrace();
                return new ResultMsg(Const.MSG_CHECK_FAILURE, Const.CODE_FAILURE,Const.FAILURE ,null);
            } catch (Exception e) {
                logger.error("Exception异常", e);
                return new ResultMsg(Const.MSG_CHECK_FAILURE, Const.SYSTEM_ERROR,Const.FAILURE ,null);
            }
        } else {
            return new ResultMsg(Const.MSG_CHECK_FAILURE, Const.CODE_FAILURE,Const.FAILURE ,null);
        }

    }
}