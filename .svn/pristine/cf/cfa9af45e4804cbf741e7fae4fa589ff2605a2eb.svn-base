package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.rest.vo.JxsSelect;
import com.yqjr.fin.mkmm.sales.rest.vo.JxsSelectResult;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.MaterialDealer;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialDealerMapper extends Mapper<MaterialDealer, Long> {

    public List<MaterialDealer> selectByMaterialOutId(MaterialDealer materialDealer);
    public List<MaterialDealer> selectOutMesForJxs(JxsSelect jxsSelect);
    public void updateForReciveStatus(MaterialDealer materialDealer);
    public List<JxsSelectResult> selectMessage(JxsSelect jxsSelect, PageBounds... pageBounds);
}
