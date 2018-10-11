package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.MaterialBaseCondition;
import com.yqjr.fin.mkmm.sales.condition.MaterialInCondition;
import com.yqjr.fin.mkmm.sales.entity.MaterialBase;
import com.yqjr.fin.mkmm.sales.rest.vo.MaterialInVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.MaterialIn;
import com.yqjr.fin.mkmm.sales.mapper.MaterialInMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import com.yqjr.scfw.common.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MaterialInService extends BaseService<MaterialInMapper, MaterialIn, Long> {

    @Autowired
    MaterialInMapper materialInMapper;
    @Autowired
    MaterialBaseService materialBaseService;
    @Autowired
    SelectCodeService selectCodeService;

    /**
     * 销管二期
     * 此素材是否被使用
     * @param materialCode
     * @return
     * create by lf
     * 2018/9/3
     */
    public List<MaterialIn> selectByMaterialCode(String materialCode){
        return materialInMapper.selectByMaterialCode(materialCode);
    }
    @Transactional(rollbackFor = { Exception.class })
    public Long materialUpload(MaterialInCondition materialInCondition){
        //查询素材名称
        MaterialBaseCondition materialBaseCondition = new MaterialBaseCondition();
        materialBaseCondition.setMaterialCode(materialInCondition.getMaterialCode());
        List<MaterialBase> materialBases = materialBaseService.selectList(materialBaseCondition);
        //查询品牌名称
        String brandsCode = materialInCondition.getBrandsCode();
        List<SelectCodeVo> selectCodeVos = selectCodeService.translateCode("CarBrand", brandsCode);
        UserContext userContext = SessionHolder.getUserContext();
        materialInCondition.setCompany(userContext.getComCode());
        materialInCondition.setMaterialName(materialBases.get(0).getMaterialName());
        materialInCondition.setBrandsName(selectCodeVos.get(0).getLabel());
        MaterialIn materialIn = new MaterialIn();
        BeanUtils.copyProperties(materialIn,materialInCondition);
        materialIn.setUploader(userContext.getName());
        this.insert(materialIn);
        return materialIn.getId();

    }
    public MaterialIn selectMessage(Long id){
        return materialInMapper.selectMessage(id);
    }

    /**
     *素材库查询页面2018/9/10
     * create by lf
     * @return
     */
    public List<MaterialIn> selectDataList(MaterialInVo condition,PageBounds... pageBounds) {
        return materialInMapper.selectDataList(condition,pageBounds);
    }
}