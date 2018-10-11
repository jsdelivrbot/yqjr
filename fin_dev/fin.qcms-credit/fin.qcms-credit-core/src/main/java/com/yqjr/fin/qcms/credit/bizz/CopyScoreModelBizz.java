package com.yqjr.fin.qcms.credit.bizz;

import com.yqjr.fin.qcms.credit.condition.ScoreModelCondition;
import com.yqjr.fin.qcms.credit.dto.EigenvalueDto;
import com.yqjr.fin.qcms.credit.dto.ScoreMajorTermDto;
import com.yqjr.fin.qcms.credit.dto.ScoreModelDto;
import com.yqjr.fin.qcms.credit.dto.ScoreSubitemDto;
import com.yqjr.fin.qcms.credit.entity.Eigenvalue;
import com.yqjr.fin.qcms.credit.entity.ScoreMajorTerm;
import com.yqjr.fin.qcms.credit.entity.ScoreSubitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CopyScoreModelBizz {
    @Autowired
    private ScoreModelBizz modelBizz;
    @Autowired
    private ScoreMajorTermBizz majorTermBizz;
    @Autowired
    private ScoreSubitemBizz subitemBizz;
    @Autowired
    private EigenvalueBizz eigenvalueBizz;

    /**
     * @param scoreModelName 传入评分模型的名称
     * @return 返回该名称评分模型的ID
     */
    public Long getScoreModelId(String scoreModelName) {
        ScoreModelCondition scoreModelCondition = new ScoreModelCondition();
        scoreModelCondition.setModelName(scoreModelName);
        ScoreModelDto scoreModelDto = modelBizz.getOne(scoreModelCondition);
        return scoreModelDto.getId();
    }

    /**
     * @param modelId 评分模型ID用于查询该评分模型下的所有评分大项
     * @return 返回该评分模型下的所有评分大项ID
     */
    public List<Long> getScoreMajorTerm(Long modelId) {
        List<Long> result = new ArrayList<>();
        //查询出该评分模型ID下的所有评分大项
        Example example = new Example(ScoreMajorTerm.class);
        example.createCriteria().andEqualTo("scoreModelId", modelId);
        List<ScoreMajorTermDto> majorTermDtos = majorTermBizz.find(example);
        for (ScoreMajorTermDto majorTermDto : majorTermDtos) {
            result.add(majorTermDto.getId());
        }
        return result;
    }

    /**
     * @param majorTermId 评分大项的ID用于查询该大项下的所有子项
     * @return 返回该评分大项下的所有评分子项ID
     */
    public List<Long> getScoreSubitem(Long majorTermId) {
        List<Long> result = new ArrayList<>();
        //查询出该评分大项ID下的所有评分子项
        Example example = new Example(ScoreSubitem.class);
        example.createCriteria().andEqualTo("scoreMajorTermId", majorTermId);
        List<ScoreSubitemDto> subitemDtos = subitemBizz.find(example);
        for (ScoreSubitemDto subitem : subitemDtos) {
            result.add(subitem.getId());
        }
        return result;
    }

    /**
     * @param subitemId 传入一个评分子项的ID用于查询该子项下的特征值
     * @return
     */
    public List<Long> getEigenValue(Long subitemId) {
        List<Long> result = new ArrayList<>();
        //查询出该评分子项ID下的所有特征值
        Example example = new Example(Eigenvalue.class);
        example.createCriteria().andEqualTo("scoreSubitemId", subitemId);
        List<EigenvalueDto> eigenvalueDtos = eigenvalueBizz.find(example);
        for (EigenvalueDto eigenValueDto : eigenvalueDtos) {
            result.add(eigenValueDto.getId());
        }
        return result;
    }

    /**
     * @param scoreModelId 根据传入的ID查询出需要复制的评分模型，修改ID后添加
     * @return 复制后的新评分模型ID
     */
    public Long copyScoreModel(Long scoreModelId) {
        ScoreModelDto scoreModelDto = modelBizz.get(scoreModelId);
        scoreModelDto.setId(null);
        return modelBizz.create(scoreModelDto);
    }

    /**
     * @param scoreModelId 根据传入的评分模型ID复制评分大项，修改ModelId
     * @return
     */
    public List<Long> copyScoreMajorTerm(Long scoreModelId) {
        List<Long> result = new ArrayList<>();
        return result;
    }
}
