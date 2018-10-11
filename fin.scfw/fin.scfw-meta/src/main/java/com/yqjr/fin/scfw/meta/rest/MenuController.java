package com.yqjr.fin.scfw.meta.rest;

import com.yqjr.fin.scfw.meta.common.Constants;
import com.yqjr.fin.scfw.meta.common.JQGridJsonResult;
import com.yqjr.fin.scfw.meta.condition.MenuCondition;
import com.yqjr.fin.scfw.meta.entity.Menu;
import com.yqjr.fin.scfw.meta.services.MenuService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.rest.BaseRest;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(consumes = "application/json", produces = "application/json",  protocols = "http",  basePath = "menu")
@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseRest<MenuService, MenuCondition> {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "查询全部可显示菜单记录", tags = "菜单信息：MenuController")
    @RequestMapping(value = "/selectMenuList", method = RequestMethod.GET)
    public ListResultResponse<MenuCondition> selectMenuList(@RequestParam Long systemId){
        UserContext uc = SessionHolder.getUserContext();
        String roleIdList=uc.getRoleIdList();
        Long sysId=systemId==0?uc.getRoleSystemIdList().get(0).longValue():systemId;
        List<MenuCondition> list = baseService.selectMenu(roleIdList,sysId);
        System.out.println(list);
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, list);
    }
}