package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.fin.mkmm.sales.condition.MaterialOutCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.JxsSelect;
import com.yqjr.fin.mkmm.sales.rest.vo.MaterialOutHisExport;
import com.yqjr.fin.mkmm.sales.rest.vo.MaterialOutVo;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.MaterialOut;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialOutMapper extends Mapper<MaterialOut, Long> {

    public void insertToMaterialOut(MaterialOutVo condition);

    /**
     * 推送记录信息查询
     * @return
     */
    public List<MaterialOutHisExport> selectMsg(MaterialOutCondition condition, PageBounds... pageBounds);
}
