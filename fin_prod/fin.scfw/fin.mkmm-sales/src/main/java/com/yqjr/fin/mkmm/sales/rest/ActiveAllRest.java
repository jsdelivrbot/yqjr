package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.ExcelUtils;
import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.entity.TeamHis;
import com.yqjr.fin.mkmm.sales.model.Active;
import com.yqjr.fin.mkmm.sales.model.ActiveReview;
import com.yqjr.fin.mkmm.sales.services.ActiveReviewService;
import com.yqjr.fin.mkmm.sales.services.ActiveService;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanna on 2018/6/4.
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "activeAlls")
@RestController
@RequestMapping(value = "/activeAlls")
public class ActiveAllRest {
    private static Logger logger = LoggerFactory.getLogger(ActiveAllRest.class);
    @Autowired
    private ActiveService activeService;

    @ApiOperation(value = "查看活动", tags = "查看活动")
    @RequestMapping(value = "/queryActive", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<Active> queryActive(@RequestParam(value = "activeCode") String activeCode) {
            UserContext userContext=SessionHolder.getUserContext();
            String company = userContext.getComCode();//公司
            Active act = activeService.selectActiveByCode(activeCode,company);
            return new ResultMsg<Active>( Const.MSG_ADD_SUCCESS, null ,Const.SUCCESS, act);

    }

}
