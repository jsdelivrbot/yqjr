package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.entity.MaterialOut;
import com.yqjr.fin.mkmm.sales.rest.vo.JxsSelect;
import com.yqjr.fin.mkmm.sales.rest.vo.JxsSelectResult;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.MaterialDealer;
import com.yqjr.fin.mkmm.sales.mapper.MaterialDealerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MaterialDealerService extends BaseService<MaterialDealerMapper, MaterialDealer, Long> {

    @Autowired
    MaterialOutService materialOutService;
    @Autowired
    MaterialDealerMapper materialDealerMapper;


    /**
     * 通过素材上传id查询素材经销商对象
     * @param materialDealer
     * @return
     */
    public List<MaterialDealer> selectByMaterialOutId(MaterialDealer materialDealer){
        return materialDealerMapper.selectByMaterialOutId(materialDealer);
    }

    /**
     * 将素材经销商对象存入JxsSelectResult对象中
     * @param jxsSelect
     * @return
     */
    public List<JxsSelectResult> selectMessage(JxsSelect jxsSelect,PageBounds... pageBounds){
        if(jxsSelect.getDealerCode()==null||jxsSelect.getDealerCode()==""||jxsSelect.getCompany()==null||jxsSelect.getCompany()==""){
            List<JxsSelectResult> list = new ArrayList<JxsSelectResult>();
            return list;
        }
        return materialDealerMapper.selectMessage(jxsSelect,pageBounds);
    }

    /**
     * 查询素材经销商对象
     * @param jxsSelect
     * @return
     */
    public List<MaterialDealer> selectOutMesForJxs(JxsSelect jxsSelect){
        return materialDealerMapper.selectOutMesForJxs(jxsSelect);
    }

    /**
     * 销管二期
     * 经销商点击接收按钮修改状态
     * @param materialOut
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    public void update(MaterialOut materialOut){
        if ("".equals(materialOut.getId()) || materialOut.getId() == null) {
            throw new ValidationException("id不能为空！");
        }
        MaterialDealer materialDealer1 = this.selectById(materialOut.getId());
        String receiveStatus = materialDealer1.getReceiveStatus();
        if ("1".equals(receiveStatus)) {
            throw new ValidationException("素材重复接收！请检查");
        }
        MaterialDealer materialDealer = new MaterialDealer();
        materialDealer.setId(materialOut.getId());
        materialDealer.setOpinion(materialOut.getOpinion());
        Date date = new Date();
        materialDealer.setReceiveTime(date);

        materialDealerMapper.updateForReciveStatus(materialDealer);
    }
}