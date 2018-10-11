package com.yqjr.fin.fpms.product.bizz;

import com.yqjr.fin.common.base.starter.enums.BusinessEnum;
import com.yqjr.fin.fpms.product.entity.FinanceProjectEntity;
import com.yqjr.fin.fpms.product.dao.FinanceProjectDao;
import com.yqjr.fin.fpms.product.dto.FinanceProjectDto;
import com.yqjr.fin.fpms.product.entity.ProductEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;

import java.util.List;

/**
* 金融专案表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 10:51:18
*/
@Service
@Transactional(readOnly = true)
public class FinanceProjectBizz extends BaseMapperBizz<FinanceProjectDao, FinanceProjectEntity, Long,FinanceProjectDto> {

    /**
     * 获取某一产品树节点下的金融专案列表
     * @param nodeId 产品树节点id
     * @return 金融专案列表
     */
    public List<FinanceProjectEntity> getProjectByNode(Long nodeId){
        FinanceProjectEntity projectEntity = new FinanceProjectEntity();
        projectEntity.setTreeNodeId(nodeId);
        projectEntity.setFlag(Long.valueOf(BusinessEnum.EFFECTIVE_FLAG.getCode()));
        return dao.select(projectEntity);
    }
	
}