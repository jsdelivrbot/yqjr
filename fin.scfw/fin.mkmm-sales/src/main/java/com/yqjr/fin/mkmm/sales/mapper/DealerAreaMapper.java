package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.rest.vo.*;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.DealerArea;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealerAreaMapper extends Mapper<DealerArea, Long> {
    /**
     * 查询业务数据
     */
	public List<DealerAreaVo> traverseInformation();
	public void deleteAll();
	public List<SelectMenuVo> selectTreeMsg();
	public List<AreaMsgVo> selectAreaMsg(String company);
	public List<DealerAreaVo> selectDealerMsg(String company);
	public List<BrandsMsgVo> selectBrandsMsg(String company);
}
