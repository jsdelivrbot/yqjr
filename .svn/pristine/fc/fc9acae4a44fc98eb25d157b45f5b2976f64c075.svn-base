package com.yqjr.fin.qcms.credit.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.dao.ScoreMajorTermDao;
import com.yqjr.fin.qcms.credit.dto.ScoreMajorTermDto;
import com.yqjr.fin.qcms.credit.entity.ScoreMajorTerm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 评分大项表逻辑处理层，该类为小的Bizz类,
 * 只简单操作对应的Dao（持久）层方法，
 * 具体业务由大的Bizz类实现
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:30:41
 */
@Service
@Slf4j
@Transactional(readOnly = true)
public class ScoreMajorTermBizz extends BaseMapperBizz<ScoreMajorTermDao, ScoreMajorTerm, Long, ScoreMajorTermDto> {
    @Autowired
    private ScoreModelBizz scoreModelBizz;

    /**
     * 验证模型名称是否重复,若重复则抛出重复异常，不重复则返回0
     */
    public int verifyRepetition(String majorTermName) {
        ScoreMajorTerm scoreMajorTerm = new ScoreMajorTerm();
        scoreMajorTerm.setScoreMajorTermName(majorTermName);
        int i = this.dao.selectCount(scoreMajorTerm);
        if (i == 0) {
            return i;
        } else {
            throw new RepetitionException(ServiceResponseEnum.NAME_ALREADY_EXIST);
        }
    }

    /**
     * 验证大项序号是否重复,若重复抛出重复异常，不重复则返回0
     */
    public int verifyRepetitionSequce(Long sequeceNumber) {
        ScoreMajorTerm scoreMajorTerm = new ScoreMajorTerm();
        scoreMajorTerm.setSequenceNumber(sequeceNumber);
        int i = this.dao.selectCount(scoreMajorTerm);
        if (i == 0) {
            return i;
        } else {
            throw new RepetitionException(ServiceResponseEnum.CODE_ALREADY_EXIST);
        }
    }

    /**
     * 评分大项新增，同时设置相应的默认值
     */
    public Long saveScoreMajor(ScoreMajorTermDto scoreMajorTermDto) {
        //评分大项默认值设置
        scoreMajorTermDto.setFlag(0);
        if (this.verifyRepetition(scoreMajorTermDto.getScoreMajorTermName()) == 0 && this.verifyRepetitionSequce(scoreMajorTermDto.getSequenceNumber()) == 0) {
            return  this.create(scoreMajorTermDto);
        }else {
            return  0L;
        }
    }


    /**
     * @param scoreModelId 根据modelId查询出该评分模型下的所有评分大项
     *                     查询出该频分模型下的所有评分大项，然后再进行遍历新增，其中评分大项的id要表示为null
     * @return 返回从数据库中查询出的评分大项IDs
     */
    public Map<String, Object> copyScoreMajor(Long scoreModelId) {
        ScoreMajorTerm scoreMajorTerm = new ScoreMajorTerm();
        scoreMajorTerm.setScoreModelId(scoreModelId);
        Map<String, Object> result = new HashMap<>();
        Map<Long, Long> majorIds = new HashMap<>();
        //调用scoreModelBizzz的复制方法，并返回新的scoreModelId
        Long newScoreModelId = scoreModelBizz.copyScoreModel(scoreModelId);
        //查询出该评分模型下的所有评分大项，并遍历添加进数据库，同时在map中以key-value的形式装入oldMajorId和newMajorId
        for (ScoreMajorTerm scoreMajorTermCopy :
                this.dao.select(scoreMajorTerm)) {
            //取出该评分模板下的所有评分大项的Id
            Long oldMajorId = scoreMajorTermCopy.getId();
            scoreMajorTermCopy.setId(null);
            scoreMajorTermCopy.setScoreModelId(newScoreModelId);
            majorIds.put(oldMajorId, this.create(this.toDto(scoreMajorTermCopy)));
        }
        result.put("newScoreModelId", newScoreModelId);
        result.put("majorIds", majorIds);
        return result;
    }
}