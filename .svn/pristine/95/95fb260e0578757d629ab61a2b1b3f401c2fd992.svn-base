package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.rest.vo.MaterialInVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.MaterialIn;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialInMapper extends Mapper<MaterialIn, Long> {

    public List<MaterialIn> selectByMaterialCode(String materialCode);
    public MaterialIn selectMessage(Long id);
    public List<MaterialIn> selectDataList(MaterialInVo condition, PageBounds... pageBounds);
}
