package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.ScoreModelVerifyDetailCondition;
import com.yqjr.fin.qcms.credit.bizz.ScoreModelVerifyDetailBizz;
import com.yqjr.fin.qcms.credit.dto.ScoreModelVerifyDetailDto;

/**
* 评分卡模型验证详情主表 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:30
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "scoreModelVerifyDetails")
@RestController
@RequestMapping(value = "/scoreModelVerifyDetails")
public class ScoreModelVerifyDetailRest extends BaseRest<ScoreModelVerifyDetailBizz,Long, ScoreModelVerifyDetailDto, ScoreModelVerifyDetailCondition>  {

}