package com.yqjr.fin.qcms.credit.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.common.base.starter.enums.ConstantsEnum;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.dao.ScoreModelDao;
import com.yqjr.fin.qcms.credit.dto.ScoreModelDto;
import com.yqjr.fin.qcms.credit.entity.ScoreModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 评分模型主表	逻辑处理层，该类为小的Bizz类,
 * 只简单操作对应的Dao（持久）层方法，
 * 具体业务由大的Bizz类实现
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:30:41
 */
@Service
@Transactional(readOnly = true)
@Slf4j
public class ScoreModelBizz extends BaseMapperBizz<ScoreModelDao, ScoreModel, Long, ScoreModelDto>{
    /**
     * 验证模型名称是否重复,若重复则返回1不重复则返回非0
     */
    public int verifyRepetition(String modelName) {
        ScoreModel scoreModel = new ScoreModel();
        scoreModel.setModelName(modelName);
        int i = this.dao.selectCount(scoreModel);
        if (i > 0) {
            throw new RepetitionException(ServiceResponseEnum.NAME_ALREADY_EXIST);
        } else {
            return i;
        }
    }
    /**
     * 模型复制(基本信息、评分项、调节系数)
     */
    public Long copyScoreModel(Long scoreModelId) {
        ScoreModelDto scoreModelDtoFromDB = this.get(scoreModelId);
        scoreModelDtoFromDB.setId(null);
        return this.create(scoreModelDtoFromDB);
    }
    /**
     * 评分模型新增，同时设置相应的默认值
     */
    public Long saveScoreModel(ScoreModelDto scoreModelDto) {
        scoreModelDto.setModelStatusCode(ConstantsEnum.WAIT_SHELVES.getCode());
        scoreModelDto.setModelStatusName(ConstantsEnum.WAIT_SHELVES.getMessage());
        scoreModelDto.setExamineStatusCode(ConstantsEnum.BEFORE_EXAMINE.getCode());
        scoreModelDto.setExamineStatusName(ConstantsEnum.BEFORE_EXAMINE.getMessage());
        scoreModelDto.setCreateTime(new Date());
        return (this.verifyRepetition(scoreModelDto.getModelName()) != 0) ?0L: this.create(scoreModelDto);
    }
}