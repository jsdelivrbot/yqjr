package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.rest.vo.DealerBrandsVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.DealerBrandsAssociated;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealerBrandsAssociatedMapper extends Mapper<DealerBrandsAssociated, Long> {

    /**
     * 查询表中所有数据
     * @return
     */
    public List<DealerBrandsVo> selectAllMsg();

    /**
     * 删除表中所有数据
     */
    public void deleteAllMsg();
	
}
