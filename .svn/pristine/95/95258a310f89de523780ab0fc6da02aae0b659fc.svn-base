package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.DealerBrandsCondition;
import com.yqjr.fin.mkmm.sales.entity.DealerBrandsAssociated;
import com.yqjr.fin.mkmm.sales.rest.vo.BrandsMsgVo;
import com.yqjr.fin.mkmm.sales.rest.vo.DealerBrandsVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.DealerBrands;
import com.yqjr.fin.mkmm.sales.mapper.DealerBrandsMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DealerBrandsService extends BaseService<DealerBrandsMapper, DealerBrands, Long> {

    @Autowired
    DealerBrandsAssociatedService dealerBrandsAssociatedService;
    @Autowired
    DealerBrandsMapper dealerBrandsMapper;
    /**
     * 经销商与品牌信息获取
     */
    @Transactional(rollbackFor = {Exception.class})
    public void traverseInformation(){
        List<DealerBrandsVo> dealerBrandsVos = dealerBrandsMapper.selectAllMsg();
        DealerBrandsVo dealerBrandsVo = null;
        String value = null;
        String[] values = null;
        DealerBrandsAssociated dealerBrandsAssociated = new DealerBrandsAssociated();
        for(int i=0;i<dealerBrandsVos.size();i++){
            dealerBrandsVo = dealerBrandsVos.get(i);
            value = dealerBrandsVo.getValueCode();
            if(value != null && value != ""){
                if(value.contains("_")){
                    values = value.split("_");
                    for(int j=0;j<values.length;j++){
                        dealerBrandsVo.setValueCode(values[j]);
                        dealerBrandsAssociated.setCompany(dealerBrandsVo.getCompany());
                        dealerBrandsAssociated.setValueCode(dealerBrandsVo.getValueCode());
                        dealerBrandsAssociated.setDealercode(dealerBrandsVo.getDealerCode());
                        dealerBrandsAssociated.setDealername(dealerBrandsVo.getDealerName());
                        dealerBrandsAssociatedService.insert(dealerBrandsAssociated);
                    }
                }else if (value.contains(",")){
                    values = value.split(",");
                    for(int j=0;j<values.length;j++){
                        dealerBrandsVo.setValueCode(values[j]);
                        dealerBrandsAssociated.setCompany(dealerBrandsVo.getCompany());
                        dealerBrandsAssociated.setValueCode(dealerBrandsVo.getValueCode());
                        dealerBrandsAssociated.setDealercode(dealerBrandsVo.getDealerCode());
                        dealerBrandsAssociated.setDealername(dealerBrandsVo.getDealerName());
                        dealerBrandsAssociatedService.insert(dealerBrandsAssociated);
                    }
                }else{
                    dealerBrandsAssociated.setCompany(dealerBrandsVo.getCompany());
                    dealerBrandsAssociated.setValueCode(dealerBrandsVo.getValueCode());
                    dealerBrandsAssociated.setDealercode(dealerBrandsVo.getDealerCode());
                    dealerBrandsAssociated.setDealername(dealerBrandsVo.getDealerName());
                    dealerBrandsAssociatedService.insert(dealerBrandsAssociated);
                }
            }

        }

        //查询出所有经销商与品牌的数据
        List<DealerBrandsVo> lists = this.selectAllMsg();
        //将数据存入表中
        DealerBrandsVo dealerBrandsVo1 = null;
        DealerBrands dealerBrands = new DealerBrands();
        for(int i=0;i<lists.size();i++){
            dealerBrandsVo1 = lists.get(i);
            dealerBrands.setCompany(dealerBrandsVo1.getCompany());
            dealerBrands.setBrandsCode(dealerBrandsVo1.getBrandsCode());
            dealerBrands.setBrandsName(dealerBrandsVo1.getBrandsName());
            dealerBrands.setDealerCode(dealerBrandsVo1.getDealerCode());
            dealerBrands.setDealerName(dealerBrandsVo1.getDealerName());
            this.insert(dealerBrands);
        }
    }

    public List<DealerBrandsVo> selectAllMsg(){
        return dealerBrandsAssociatedService.selectAllMsg();
    }

    /**
     * 经销商与区域信息清除
     */
    public void cleanTable(){
        dealerBrandsAssociatedService.deleteAllMsg();
        dealerBrandsMapper.deleteAllMsg();
    }

    /**
     * create by lf
     * 2018/9/8
     * @return
     */
    public List<BrandsMsgVo> selectTreeMsg(){
        UserContext userContext = SessionHolder.getUserContext();
        List<BrandsMsgVo> brandsMsgVos = dealerBrandsMapper.selectBrands(userContext.getComCode());
        //查询经销商信息并组合品牌信息
        for(int i=0;i<brandsMsgVos.size();i++){
            brandsMsgVos.get(i).setId(brandsMsgVos.get(i).getValueI());
        }
       // List<SelectMenuVo> selectMenuVos = slectBrandsDealer(brandsMsgVos);

        return brandsMsgVos;
    }

    /**
     * 查询经销商信息并组合品牌信息
     * 2018/9/8
     * @param brandsMsgVos
     * @return
     */
    List<SelectMenuVo> slectBrandsDealer(List<BrandsMsgVo> brandsMsgVos){
        BrandsMsgVo brandsMsgVo = null;
        UserContext userContext = SessionHolder.getUserContext();
        String company = userContext.getComCode();
        DealerBrandsCondition dealerBrandsCondition = new DealerBrandsCondition();
        DealerBrands dealerBrands = null;

        List<SelectMenuVo> selectMenuVos1 = new ArrayList<>();
        for(int i=0;i<brandsMsgVos.size();i++){
            SelectMenuVo selectMenuVo1 = new SelectMenuVo();
            brandsMsgVo = brandsMsgVos.get(i);
            dealerBrandsCondition.setBrandsCode(brandsMsgVo.getValueI());
            dealerBrandsCondition.setCompany(company);
            List<DealerBrands> brands = this.selectList(dealerBrandsCondition);
            List<SelectMenuVo> selectMenuVos = new ArrayList<>();
            for(int j=0;j<brands.size();j++){
                SelectMenuVo selectMenuVo = new SelectMenuVo();
                dealerBrands = brands.get(j);
                selectMenuVo.setId(brandsMsgVo.getId());
                selectMenuVo.setTitle(dealerBrands.getDealerName());
                selectMenuVo.setValue(dealerBrands.getDealerCode());
                selectMenuVos.add(selectMenuVo);
            }
            selectMenuVo1.setId(brandsMsgVo.getId());
            selectMenuVo1.setValue(brandsMsgVo.getValueI());
            selectMenuVo1.setTitle(brandsMsgVo.getTitle());
            selectMenuVo1.setChildren(selectMenuVos);
            selectMenuVos1.add(selectMenuVo1);
        }
        return selectMenuVos1;
    }

    /**
     * 根据品牌编码查询经销商
     * @param code
     * @return
     */
    public List<SelectMenuVo> selectByCode(String code){
        UserContext userContext = SessionHolder.getUserContext();
        DealerBrandsCondition dealerBrandsCondition = new DealerBrandsCondition();
        dealerBrandsCondition.setCompany(userContext.getComCode());
        dealerBrandsCondition.setBrandsCode(code);
        List<DealerBrands> dealerBrands = this.selectList(dealerBrandsCondition);
        DealerBrands dealerBrand = null;
        List<SelectMenuVo> selectMenuVos = new ArrayList<>();
        for (int i=0;i<dealerBrands.size();i++) {
            dealerBrand = dealerBrands.get(i);
            SelectMenuVo selectMenuVo = new SelectMenuVo();
            selectMenuVo.setId(code);
            selectMenuVo.setValue(dealerBrand.getDealerCode());
            selectMenuVo.setTitle(dealerBrand.getDealerName());
            selectMenuVos.add(selectMenuVo);
        }
        return selectMenuVos;
    }
}