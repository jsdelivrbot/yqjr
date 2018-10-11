package com.yqjr.fin.qcms.credit.rest;

import com.ritoinfo.framework.evo.sp.base.exception.RestException;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.bizz.ScoreSubitemBizz;
import com.yqjr.fin.qcms.credit.condition.ScoreSubitemCondition;
import com.yqjr.fin.qcms.credit.dto.ScoreSubitemDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 评分子项表 rest层
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:34:30
 */
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "scoreSubitems")
@RestController
@RequestMapping(value = "/scoreSubitems")
public class ScoreSubitemRest extends BaseRest<ScoreSubitemBizz, Long, ScoreSubitemDto, ScoreSubitemCondition> {
    /**
     * @param subitemName 传入后验证在数据库中是否存在
     * @return 返回一个serviceResponse 其中serviceResponse的data是Bizz返回的一个int，0则为数据库不存在该数据，1则为数据库已存在该数据,
     */

    @GetMapping(value = "/verifyRepetition")
    public ServiceResponse verifyRepetition(@RequestParam(value = "subitemName") String subitemName) {
        try {
            this.bizz.verifyRepetition(subitemName);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok();
    }
    /**
     * @param sequenceNumber 传入后验证在数据库中是否存在
     * @return 返回一个serviceResponse 其中serviceResponse的data是Bizz返回的一个int，0则为数据库不存在该数据，1则为数据库已存在该数据,
     */
    @GetMapping(value = "/verifyRepetitionSquece")
    public ServiceResponse verifyRepetitionSquece(@RequestParam(value = "sequenceNumber") Long sequenceNumber) {
        try {
            this.bizz.verifyRepetitionSequce(sequenceNumber);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok();
    }
    /**
     *
     * @param scoreSubitemDto 传入评分子项的参数表单
     * @return 返回一个评分子项的ID
     */
    @PostMapping(value = "/saveScoreSubitems")
    public ServiceResponse saveScoreSubitems(@RequestBody() ScoreSubitemDto scoreSubitemDto) {
        Long data;
        try {
            data=this.bizz.saveScoreSubitems(scoreSubitemDto);
        }catch (RepetitionException e){
            e.printStackTrace();
            throw new RestException(e.getCode(),e.getMessage());
        }
        return ServiceResponse.ok(data);
    }

}