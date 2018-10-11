package com.yqjr.fin.qcms.credit.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.RepetitionException;
import com.yqjr.fin.qcms.credit.dao.ScoreSubitemDao;
import com.yqjr.fin.qcms.credit.dto.ScoreSubitemDto;
import com.yqjr.fin.qcms.credit.entity.ScoreSubitem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 评分子项表逻辑处理层，该类为小的Bizz类,
 * 只简单操作对应的Dao（持久）层方法，
 * 具体业务由大的Bizz类实现
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:30:42
 */
@Service
@Slf4j
@Transactional(readOnly = true)
public class ScoreSubitemBizz extends BaseMapperBizz<ScoreSubitemDao, ScoreSubitem, Long, ScoreSubitemDto> {
    @Autowired
    private ScoreMajorTermBizz majorTermBizz;

    /**
     * 验证评分子项名称是否重复,若重复则抛出重复异常，不重复则返回0
     */
    public int verifyRepetition(String subitemName) {
        ScoreSubitem scoreSubitem = new ScoreSubitem();
        scoreSubitem.setScoreSubitemName(subitemName);
        int i = this.dao.selectCount(scoreSubitem);
        if (i == 0) {
            return i;
        } else {
            throw new RepetitionException(ServiceResponseEnum.NAME_ALREADY_EXIST);
        }
    }

    /**
     * 验证模序号是否重复,若重复则抛出重复异常，不重复则返回0
     */
    public int verifyRepetitionSequce(Long sequeceNumber) {
        ScoreSubitem scoreSubitem = new ScoreSubitem();
        scoreSubitem.setSequenceNumber(sequeceNumber);
        int i = this.dao.selectCount(scoreSubitem);
        if (i == 0) {
            return i;
        } else {
            throw new RepetitionException(ServiceResponseEnum.CODE_ALREADY_EXIST);
        }

    }

    /**
     * 评分模型子项新增，同时设置相应的默认值
     */
    public Long saveScoreSubitems(ScoreSubitemDto scoreSubitemDto) {
        //设置默认值
        scoreSubitemDto.setCreateTime(new Date());
        //验证序号和名称
        scoreSubitemDto.setFlag(0);
        if (this.verifyRepetition(scoreSubitemDto.getScoreSubitemName()) == 0 && this.verifyRepetitionSequce(scoreSubitemDto.getSequenceNumber()) != 0) {
            return  this.create(scoreSubitemDto);
        }else {
            return  0L;
        }
    }
    /**
     * @param scoreModelId 根据scoreMajorIds查询出该评分模型下的所有评分子项
     * @return 返回数据库中查询出来的所有评分子项的IDs
     */
    public Map<String, Object> copyScoreSubitem(Long scoreModelId) {
        ScoreSubitem subitem = new ScoreSubitem();
        subitem.setScoreModelId(scoreModelId);
        //获取返回的id，其中有新的模型id，新的和旧的大项id
        Map<String, Object> result = majorTermBizz.copyScoreMajor(scoreModelId);
        Long newScoreModelId = (Long) result.get("newScoreModelId");
        Map<Long, Long> majorIds = (Map<Long, Long>) result.get("majorIds");
        Map<Long, Long> subitemIds = new HashMap<>();
        for (Long majorId :
                majorIds.keySet()) {
            subitem.setScoreMajorTermId(majorId);
            for (ScoreSubitem subitemFormDB : this.dao.select(subitem)) {
                Long oldSubitemId = subitemFormDB.getId();
                subitemFormDB.setId(null);
                subitemFormDB.setScoreModelId(newScoreModelId);
                subitemFormDB.setScoreMajorTermId(majorIds.get(majorId));
                subitemIds.put(oldSubitemId, this.create(this.toDto(subitemFormDB)));
            }
        }
        result.put("subitemIds", subitemIds);
        return result;
    }

}