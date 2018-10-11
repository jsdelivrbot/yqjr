package com.yqjr.fin.qcms.credit.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import com.yqjr.fin.common.base.starter.exception.ModelIncompleteException;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.bizz.EigenvalueBizz;
import com.yqjr.fin.qcms.credit.bizz.ScoreModelBizz;
import com.yqjr.fin.qcms.credit.bizz.VerifyScoreModelCompleteBizz;
import com.yqjr.fin.qcms.credit.condition.ScoreModelCondition;
import com.yqjr.fin.qcms.credit.dto.ScoreModelDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评分模型主表	 rest层
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:34:30
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "scoreModels")
@RestController
@RequestMapping(value = "/scoreModels")
public class ScoreModelRest extends BaseRest<ScoreModelBizz, Long, ScoreModelDto, ScoreModelCondition> {
    @Autowired
    private EigenvalueBizz eigenvalueBizz;
    @Autowired
    private VerifyScoreModelCompleteBizz verifyScoreModelCompleteBizz;

    /**
     * 该接口暴露给前端用于失去焦点时进行查重，用异步刷新
     *
     * @param modelName 传入modelName后验证在数据库中是否存在
     * @return 返回一个serviceResponse 其中serviceResponse的data是Bizz返回的一个int，0则为数据库不存在该数据，1则为数据库已存在该数据，
     * 然而我并不需要这玩意儿，直接在service层抛出了异常
     */
    @GetMapping(value = "/verifyRepetition")
    public ServiceResponse verifyRepetition(@RequestParam(value = "modelName") String modelName) {
        try {
            this.bizz.verifyRepetition(modelName);
        } catch (RepetitionException e) {
            e.printStackTrace();
            throw new RestException(e.getCode(), e.getMessage());
        }
        return ServiceResponse.ok();
    }

    /**
     * 评分模型新增
     */
    @PostMapping(value = "/saveScoreModel")
    public ServiceResponse saveScoreModel(@RequestBody() ScoreModelDto scoreModelDto) {
        try {
            this.bizz.saveScoreModel(scoreModelDto);
        } catch (RepetitionException e) {
            e.printStackTrace();
            throw new RestException(e.getCode(), e.getMessage());
        }
        return ServiceResponse.ok();
    }

    /**
     * 模型复制(基本信息、评分项、调节系数)
     * 复制的操作会将所有信息返回到前台，包括和整个评分模型树
     */
    @GetMapping(value = "/copyScoreModel")
    public ServiceResponse copyScoreModel(Long scoreModelId) {
        return ServiceResponse.ok(eigenvalueBizz.copyEigenvalue(scoreModelId));
    }

    /**
     * @param scoreModelId 传入评分模型ID，验证其模型是否完整
     * @return
     */
    @GetMapping(value = "/verifyModelComplete")
    public ServiceResponse verifyModelComplete(@RequestParam(value = "scoreModelId") Long scoreModelId) {
        try {
            verifyScoreModelCompleteBizz.verifyScoreModelComplete(scoreModelId);
        } catch (ModelIncompleteException e) {
            throw new RestException(e.getMessage());
        }
        return ServiceResponse.ok();
    }
}