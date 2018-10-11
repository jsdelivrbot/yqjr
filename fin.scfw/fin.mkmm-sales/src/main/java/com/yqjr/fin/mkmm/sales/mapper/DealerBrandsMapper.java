package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.rest.vo.BrandsMsgVo;
import com.yqjr.fin.mkmm.sales.rest.vo.DealerBrandsVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.DealerBrands;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealerBrandsMapper extends Mapper<DealerBrands, Long> {

    /**
     * 经销商与品牌业务信息获取
     * @return
     */
	public List<DealerBrandsVo> selectAllMsg();
    public void deleteAllMsg();
    //查询品牌信息
    public List<BrandsMsgVo> selectBrands(String company);
}
