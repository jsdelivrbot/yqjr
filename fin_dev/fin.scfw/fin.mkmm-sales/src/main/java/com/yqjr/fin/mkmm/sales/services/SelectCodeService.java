package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.ProductCodeCondition;
import com.yqjr.fin.mkmm.sales.entity.ProductCode;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectProductCodeVo;
import com.yqjr.fin.mkmm.sales.services.gateway.MetaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by zhouchong on 2018/5/29.
 */
@Service
@Transactional(readOnly = true)
public class SelectCodeService {
    @Autowired
    private MetaGateway metaGateway;

    @Autowired
    private ProductCodeService productCodeService;

    /**
     *
     * @param codeType 代码类型
     * @param isUpCode 是否有上级代码
     * @param upCode   上级代码
     */
    public List<SelectCodeVo> selectCode(String codeType, String isUpCode, String upCode){
        List<SelectCodeVo> selectCodeVoList = new ArrayList<SelectCodeVo>();
        List<SelectCodeVo> selectCodeVos=new ArrayList<SelectCodeVo>();
        ProductCodeCondition productCodeCondition = new ProductCodeCondition();
        List<ProductCode> productCodes = new ArrayList<ProductCode>();

        if("Zone".equals(codeType)||"Province".equals(codeType)||"City".equals(codeType)||"CarBrand".equals(codeType)
                ||"CarBrandDetail".equals(codeType)||"CarBrandName".equals(codeType)){//区域、省、市、品牌、子品牌、车系
            selectCodeVoList = metaGateway.transCode(codeType,isUpCode,upCode);
            if (selectCodeVoList != null && selectCodeVoList.size() >= 0){ //判断返回值是否为空
                SelectCodeVo selectCodeVo=new SelectCodeVo();
                selectCodeVo.setLabel("全部");
                selectCodeVo.setValue("00");
                selectCodeVos.add(selectCodeVo);
            }
            selectCodeVos.addAll(metaGateway.transCode(codeType,isUpCode,upCode));
        }else if ("CarBrandList".equals(codeType)){//品牌,不包括全部
            selectCodeVos.addAll(metaGateway.transCode("CarBrand",isUpCode,upCode));
        }else if ("marketing".equals(codeType)){//营销活动
            productCodes = productCodeService.selectByCondition("FIN_PRODUCT");
            return this.productCodesToSelectCodeVos(productCodes);
        }else if("financeProd".equals(codeType)){//金融产品
            productCodes = productCodeService.selectByCondition("PD_DLRBIZTYPE");
            return this.productCodesToSelectCodeVos(productCodes);
        }else if("business".equals(codeType)){//业务模式
            productCodes = productCodeService.selectByCondition("PD_BIZTYPE");
            return this.productCodesToSelectCodeVos(productCodes);
        }else if("creditProd".equals(codeType)){//信贷产品
            productCodes = productCodeService.selectByCondition("INTEREST_TYPE");
            return this.productCodesToSelectCodeVos(productCodes);
        }else if("additional".equals(codeType)){//附加贷
            productCodes = productCodeService.selectByCondition("EXTRACHARGE_LIST");
            return this.productCodesToSelectCodeVos(productCodes);
        }
        return selectCodeVos;
    }

    /**
     * 根据参数类型和值，查询对应名字
     * @param codeType
     * @param codeCode
     * @return
     */
    public List<SelectCodeVo> translateCode(String codeType,String codeCode){
        List<SelectCodeVo> selectCodeVos=new ArrayList<SelectCodeVo>();
        if ("00".equals(codeCode)){
            SelectCodeVo selectCodeVo = new SelectCodeVo();
            selectCodeVo.setLabel("全部");
            selectCodeVo.setValue("00");
            selectCodeVos.add(selectCodeVo);
        }else {
            selectCodeVos = metaGateway.transCode(codeType,codeCode);
        }
        return selectCodeVos;
    }


    public SelectCodeVo productCodeToSelectCodeVo(ProductCode productCode){
        SelectCodeVo selectCodeVo = new SelectCodeVo();
        selectCodeVo.setLabel(productCode.getName());
        selectCodeVo.setValue(productCode.getValue().toString());
        return selectCodeVo;
    }

    public List<SelectCodeVo> productCodesToSelectCodeVos(List<ProductCode> productCodes){
        return productCodes.stream().filter(Objects::nonNull).map(this::productCodeToSelectCodeVo).collect(Collectors.toList());
    }

    public SelectProductCodeVo productCodesToSelectProductCodeVo(List<ProductCode> productCodes){
        SelectProductCodeVo selectProductCodeVo = new SelectProductCodeVo();
        SelectCodeVo selectCodeVo1 = new SelectCodeVo();
        selectCodeVo1.setValue("00");
        selectCodeVo1.setLabel("全部");
        SelectCodeVo selectCodeVo2 = new SelectCodeVo();
        selectCodeVo2.setValue("00");
        selectCodeVo2.setLabel("全部");
        SelectCodeVo selectCodeVo3 = new SelectCodeVo();
        selectCodeVo3.setValue("00");
        selectCodeVo3.setLabel("全部");
        SelectCodeVo selectCodeVo4 = new SelectCodeVo();
        selectCodeVo4.setValue("00");
        selectCodeVo4.setLabel("全部");
        SelectCodeVo selectCodeVo5 = new SelectCodeVo();
        selectCodeVo5.setValue("00");
        selectCodeVo5.setLabel("全部");
        selectProductCodeVo.getMarketingCodes().add(selectCodeVo1);
        selectProductCodeVo.getFinanceCodes().add(selectCodeVo2);
        selectProductCodeVo.getBusinessCodes().add(selectCodeVo3);
        selectProductCodeVo.getCreditCodes().add(selectCodeVo4);
        selectProductCodeVo.getAdditionalCodes().add(selectCodeVo5);
        for (ProductCode productCode : productCodes){
            switch (productCode.getVdictcode()){
                case "FIN_PRODUCT":
                    selectProductCodeVo.getMarketingCodes().add(this.productCodeToSelectCodeVo(productCode));
                    break;
                case "PD_DLRBIZTYPE":
                    selectProductCodeVo.getFinanceCodes().add(this.productCodeToSelectCodeVo(productCode));
                    break;
                case "PD_BIZTYPE":
                    selectProductCodeVo.getBusinessCodes().add(this.productCodeToSelectCodeVo(productCode));
                    break;
                case "INTEREST_TYPE":
                    selectProductCodeVo.getCreditCodes().add(this.productCodeToSelectCodeVo(productCode));
                    break;
                case "EXTRACHARGE_LIST":
                    selectProductCodeVo.getAdditionalCodes().add(this.productCodeToSelectCodeVo(productCode));
                    break;
            }
        }
        return selectProductCodeVo;
    }

    //金融产品、业务模式、信贷产品、营销活动、附加贷子项
    public SelectProductCodeVo selectProductCodes() {
        List<ProductCode> productCodes = productCodeService.selectListAll();
        return this.productCodesToSelectProductCodeVo(productCodes);
    }
}
