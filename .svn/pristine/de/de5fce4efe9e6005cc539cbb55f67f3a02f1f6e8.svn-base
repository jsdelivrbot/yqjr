package com.yqjr.fin.qcms.credit.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.bizz.ScoreMajorTermBizz;
import com.yqjr.fin.qcms.credit.condition.ScoreMajorTermCondition;
import com.yqjr.fin.qcms.credit.dto.ScoreMajorTermDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 评分大项表 rest层
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:34:29
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "scoreMajorTerms")
@RestController
@RequestMapping(value = "/scoreMajorTerms")
public class ScoreMajorTermRest extends BaseRest<ScoreMajorTermBizz, Long, ScoreMajorTermDto, ScoreMajorTermCondition> {
    /**
     * @param majorTermName 传入后验证在数据库中是否存在
     * @return 返回一个serviceResponse 其中serviceResponse的data是Bizz返回的一个int，0则为数据库不存在该数据，1则为数据库已存在该数据。
     */
    @GetMapping(value = "/verifyRepetition")
    public ServiceResponse verifyRepetition(@RequestParam(value = "majorTermName") String majorTermName) {
        try {
            this.bizz.verifyRepetition(majorTermName);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok();
    }
    /**
     * @param sequceNumber 传入后验证在数据库中是否存在
     * @return 返回一个serviceResponse 其中serviceResponse的data是Bizz返回的一个int，0则为数据库不存在该数据，1则为数据库已存在该数据。
     */
    @GetMapping(value = "/verifyRepetitionSequce")
    public ServiceResponse verifyRepetitionSequce(@RequestParam(value = "sequceNumber") Long sequceNumber) {
        try {
            this.bizz.verifyRepetitionSequce(sequceNumber);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok();
    }

    /**
     *
     * @param scoreMajorTermDto 传入评分大项的参数表单
     * @return 返回新增的评分大项ID
     */
    @PostMapping(value = "/saveScoreMajor")
    public ServiceResponse saveScoreMajor(@RequestBody() ScoreMajorTermDto scoreMajorTermDto) {
        Long data;
        try {
            data=this.bizz.saveScoreMajor(scoreMajorTermDto);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok(data);
    }
}