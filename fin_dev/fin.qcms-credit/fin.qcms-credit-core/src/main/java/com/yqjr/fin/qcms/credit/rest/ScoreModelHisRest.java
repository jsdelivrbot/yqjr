package com.yqjr.fin.qcms.credit.rest;

import io.swagger.annotations.Api;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yqjr.fin.qcms.credit.condition.ScoreModelHisCondition;
import com.yqjr.fin.qcms.credit.bizz.ScoreModelHisBizz;
import com.yqjr.fin.qcms.credit.dto.ScoreModelHisDto;

/**
* 评分模型轨迹表	 rest层
* @Author:         zxd
* @CreateDate:     2018-08-27 10:34:30
*/
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "scoreModelHiss")
@RestController
@RequestMapping(value = "/scoreModelHiss")
public class ScoreModelHisRest extends BaseRest<ScoreModelHisBizz,Long, ScoreModelHisDto, ScoreModelHisCondition>  {

}