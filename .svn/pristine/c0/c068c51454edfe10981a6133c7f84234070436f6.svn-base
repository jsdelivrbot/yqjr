package com.yqjr.fin.qcms.credit.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.qcms.credit.dao.EigenvalueDao;
import com.yqjr.fin.qcms.credit.dto.EigenvalueDto;
import com.yqjr.fin.qcms.credit.entity.Eigenvalue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 特征值表逻辑处理层，该类为小的Bizz类,
 * 只简单操作对应的Dao（持久）层方法，
 * 具体业务由大的Bizz类实现
 *
 * @Author: zxd
 * @CreateDate: 2018-08-27 10:30:41
 */
@Service
@Transactional(readOnly = true)
public class EigenvalueBizz extends BaseMapperBizz<EigenvalueDao, Eigenvalue, Long, EigenvalueDto> {
    @Autowired
    private ScoreSubitemBizz subitemBizz;
    /**
     * 根据ModelId查询是否存在特征值
     * 编写该方法时用了example进行条件查询
     */
    public List<EigenvalueDto> selectEigenvalueByScoreModelId(Long scoreModelId) {
        Eigenvalue eigenvalue = new Eigenvalue();
        eigenvalue.setScoreModelId(scoreModelId);
        return this.toDto(this.dao.select(eigenvalue));
    }

    /**
     * @param scoreModelId 根据scoreMajorIds查询出该评分模型下的所有评分子项
     * @return 返回数据库查询的所有特征值的IDs
     */
    public Long copyEigenvalue(Long scoreModelId) {
        Eigenvalue eigenvalue = new Eigenvalue();
        Map<String, Object> result= subitemBizz.copyScoreSubitem(scoreModelId);
        Map<Long, Long> majorIds = (Map<Long, Long>) result.get("majorIds");
        Map<Long, Long> subitemIds = (Map<Long, Long>) result.get("subitemIds");
        Long newScoreModelId= (Long) result.get("newScoreModelId");
        for (Long subitemId :
                subitemIds.keySet()) {
            eigenvalue.setScoreSubitemId(subitemId);
            for (Eigenvalue eigenvalueFormDB:
                 this.dao.select(eigenvalue)) {
                eigenvalueFormDB.setId(null);
                eigenvalueFormDB.setScoreModelId(newScoreModelId);
                this.create(this.toDto(eigenvalue));
            }
        }
        return newScoreModelId;
    }
}