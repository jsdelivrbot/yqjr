package com.yqjr.fin.qcms.credit.bizz;

import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.qcms.credit.dao.AdjustCoefficientDao;
import com.yqjr.fin.qcms.credit.dto.AdjustCoefficientDto;
import com.yqjr.fin.qcms.credit.entity.AdjustCoefficient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 评分卡调节系数表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:40
*/
@Service
@Transactional(readOnly = true)
public class AdjustCoefficientBizz extends BaseMapperBizz<AdjustCoefficientDao, AdjustCoefficient, Long,AdjustCoefficientDto> {
	/**
     * 根据ModelId查询是否存在调节系数
     */
	public List<AdjustCoefficientDto> selectAdjustCoefficientByScoreModelId(Long scoreModelId){
        AdjustCoefficient adjustCoefficient = new AdjustCoefficient();
        adjustCoefficient.setScoreModelId(scoreModelId);
        return this.toDto(this.dao.select(adjustCoefficient));
    }
}