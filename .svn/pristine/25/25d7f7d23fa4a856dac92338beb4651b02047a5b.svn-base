package com.yqjr.fin.qcms.credit.bizz;

import com.yqjr.fin.common.base.starter.exception.ModelIncompleteException;
import com.yqjr.fin.qcms.credit.dao.ShowScoreModelDao;
import com.yqjr.fin.qcms.credit.dto.ShowScoreModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VerifyScoreModelCompleteBizz {
    @Autowired
    private ShowScoreModelDao showScoreModelDao;
    @Autowired
    private CopyScoreModelBizz copyScoreModelBizz;

    /**
     * 查询出所有配置信息，然后返回一个map传到前台
     */
    public List<ShowScoreModelDto> showScoreModelAllConfig(Long scoreModelId) {
        return showScoreModelDao.showScoreModel(scoreModelId);
    }

    /**
     * @param scoreModelId 传入评分模型ID
     */
    public void verifyScoreModelComplete(Long scoreModelId) {
        //该模型下的所有评分大项ID
        List<Long> scoreMajorTermIds = copyScoreModelBizz.getScoreMajorTerm(scoreModelId);
        List<Long> scoreSubitemIds;
        //判断该模型，是否存在评分大项
        if (scoreMajorTermIds != null && scoreMajorTermIds.size() != 0) {
            //遍历出一个评分大项下的评分子项
            for (Long majorTermId : scoreMajorTermIds) {
                scoreSubitemIds = copyScoreModelBizz.getScoreSubitem(majorTermId);
                //判断该评分子大项，是否存在评分子项
                if (scoreSubitemIds != null && scoreMajorTermIds.size() != 0) {
                    //遍历出一个评分子项下的所有特征值
                    for (Long scoreSubitemId : scoreSubitemIds) {
                       List<Long> eigenValueIds=copyScoreModelBizz.getEigenValue(scoreSubitemId);
                       if (eigenValueIds!=null&&eigenValueIds.size()!=0){
                       }else {
                           throw new ModelIncompleteException("特征值设计错误");
                       }
                    }
                } else {
                    throw new ModelIncompleteException("评分子项设计错误");
                }
            }
        } else {
            throw new ModelIncompleteException("评分大项设计异常");
        }
    }
}
