package com.yqjr.fin.mkmm.sales.rest;

import com.yqjr.fin.mkmm.sales.common.ResultMsg;
import com.yqjr.fin.mkmm.sales.condition.ActiveMainReviewCondition;
import com.yqjr.fin.mkmm.sales.entity.WorkFlow;
import com.yqjr.fin.mkmm.sales.model.ActiveReview;
import com.yqjr.fin.mkmm.sales.services.ActiveReviewService;
import com.yqjr.fin.mkmm.sales.rest.vo.ActiveReviewVo;
import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhouchong on 2018/6/1.
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "actives")
@RestController
@RequestMapping(value = "/actives")
public class ActiveReviewRest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ActiveReviewService activeReviewService;

    @ApiOperation(value = "新增记录（参数：activeReview）", tags = "activeReview 增删改查")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<ActiveReview> create(@RequestBody ActiveReview activeReview, Errors errors) {
        try {
            activeReviewService.insertActiveReviews(activeReview);
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_ADD_SUCCESS + "!,您的活动代码为：" + activeReview.getAtiveMain().getActiveCode(), activeReview);
        } catch (ValidationException e) {
            logger.error("ValidationException异常", e);
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, "操作失败", activeReview);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            e.printStackTrace();
            return this.getObjectResultResponse(Const.FAILURE, Const.CODE_FAILURE, "操作失败", activeReview);
        }
    }


    protected ObjectResultResponse<ActiveReview> getObjectResultResponse(boolean isSuccess, String code, String msg, ActiveReview entity) {
        ObjectResultResponse<ActiveReview> result = new ObjectResultResponse<ActiveReview>();
        result.setResult(entity);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @ApiOperation(value = "活动制定-修改", tags = "活动制定的修改")
    @RequestMapping(value = "/modifyfind", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<ActiveReview> reviewWatch(@RequestParam(value = "activeId") Long activeId) {
        try {
            ActiveReview activeReview = new ActiveReview();
            ActiveMainReviewCondition mainReviewCondition = new ActiveMainReviewCondition();
            mainReviewCondition.setId(activeId);
            activeReview = activeReviewService.getActiveReviews(mainReviewCondition);
            String str = null;
            if (activeReview != null) {
                str = "查询成功";
            } else {
                str = "查询失败";
            }
            return new ResultMsg<ActiveReview>(Const.MSG_PUT_SUCCESS, str, Const.SUCCESS, activeReview);
        } catch (ValidationException e) {
            logger.error("Exception异常", e);
            return new ResultMsg<ActiveReview>(Const.MSG_PUT_FAILURE, "操作失败", Const.FAILURE, null);
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<ActiveReview>(Const.MSG_PUT_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }

    @ApiOperation(value = "活动审核的查询", tags = "活动审核的查询")
    @RequestMapping(value = "/checkfind", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<ActiveReviewVo> checkWatch(@RequestParam(value = "id") Long id) {
//        try{
        ActiveReviewVo activeReviewVo = new ActiveReviewVo();
        activeReviewVo = activeReviewService.getActiveReviewCheck(id);
        String str = null;
        if (activeReviewVo != null) {
            str = "查询成功";
        } else {
            str = "查询失败";
        }
        return new ResultMsg<ActiveReviewVo>(Const.MSG_CHECK_SUCCESS, str, Const.SUCCESS, activeReviewVo);
//        }catch (ValidationException e){
//            return new ResultMsg<ActiveReviewVo>( Const.MSG_CHECK_FAILURE, "操作失败" ,Const.FAILURE, null);
//        }catch (Exception e) {
//            return new ResultMsg<ActiveReviewVo>( Const.MSG_CHECK_FAILURE, "操作失败" ,Const.FAILURE, null);
//        }
    }

    @ApiOperation(value = "活动审核的提交", tags = "活动审核的提交")
    @RequestMapping(value = "/checksubmit", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg<String> checkSubmit(@RequestBody WorkFlow workFlow) {
//        try{
        //        ActiveReview activeReview = new ActiveReview();
        //        activeReview = activeReviewService.getActiveReviews(id);
        activeReviewService.activeReviewSubmit(workFlow);
        return new ResultMsg<String>(Const.MSG_SUBMIT_SUCCESS, "提交成功", Const.SUCCESS, "");
//        }catch (ValidationException e){
//            return new ResultMsg<String>( Const.MSG_SUBMIT_FAILURE, "操作失败" ,Const.FAILURE, null);
//        }catch (Exception e) {
//            return new ResultMsg<String>( Const.MSG_SUBMIT_FAILURE, "操作失败" ,Const.FAILURE, null);
//        }
    }

    @ApiOperation(value = "新增修改后的活动", tags = "activeReview")
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<ActiveReview> change(@RequestBody ActiveReview activeReview, Errors errors) {
        activeReviewService.updateAndInsertActiveReviews(activeReview);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_ADD_SUCCESS, activeReview);
    }

    @ApiOperation(value = "修改待mainActiveList审核状态为审核中", tags = "修改待审核状态为审核中")
    @RequestMapping(value = "/checking", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg<String> checking(@RequestParam("id") Long id, @RequestParam("folowId") Long folowId) {
        try {
            activeReviewService.updateCheckStatus("03", id, folowId);
            return new ResultMsg<String>(Const.MSG_PUT_SUCCESS, "提交成功", Const.SUCCESS, "");
        } catch (Exception e) {
            logger.error("Exception异常", e);
            return new ResultMsg<String>(Const.MSG_PUT_FAILURE, "操作失败", Const.FAILURE, null);
        }
    }
}
