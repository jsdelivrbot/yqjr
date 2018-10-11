package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.rest.vo.DealerBrandsVo;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.DealerBrandsAssociated;
import com.yqjr.fin.mkmm.sales.mapper.DealerBrandsAssociatedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DealerBrandsAssociatedService extends BaseService<DealerBrandsAssociatedMapper, DealerBrandsAssociated, Long> {

    @Autowired
    DealerBrandsAssociatedMapper dealerBrandsAssociatedMapper;

    /**
     * 查询所有数据
     * @return
     */
    public List<DealerBrandsVo> selectAllMsg(){
        return dealerBrandsAssociatedMapper.selectAllMsg();
    }
    public void deleteAllMsg(){
        dealerBrandsAssociatedMapper.deleteAllMsg();
    }
}