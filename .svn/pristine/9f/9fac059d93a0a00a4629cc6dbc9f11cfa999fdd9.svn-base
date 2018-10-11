package com.yqjr.fin.fpms.product.bizz;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import com.yqjr.fin.common.base.starter.enums.BusinessEnum;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.fpms.product.dao.ProductTreeDao;
import com.yqjr.fin.fpms.product.dto.ProductTreeDto;
import com.yqjr.fin.fpms.product.entity.FinanceProjectEntity;
import com.yqjr.fin.fpms.product.entity.ProductEntity;
import com.yqjr.fin.fpms.product.entity.ProductTreeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@Service
public class ProductTreeBizz extends BaseMapperBizz<ProductTreeDao, ProductTreeEntity, Long, ProductTreeDto> {

    @Autowired
    ProductBizz productBizz;

    @Autowired
    FinanceProjectBizz projectBizz;


    /** 
     * @Author: lixue
     * @Description:  产品树列表
     * @Date:  2018/8/30 10:49
     * @params: company 公司  businessLine 业务条线
     * @returns: 
     * 
     */
    public JSONArray productTreeList(Long company,Long businessLine,Long parentId){
        List<ProductTreeEntity> list = childTreeNodeSelect(company,businessLine,parentId);
        JSONArray jsonArray = new JSONArray();
        for(ProductTreeEntity productTree:list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",productTree.getId());
            jsonObject.put("name",productTree.getNodeName());
            jsonObject.put("levelNumber",productTree.getLevelNumber());
            //jsonObject.put("isFinalNode",productTree.getIsFinalNode());
            jsonObject.put("showButton",showButton(productTree));
            //当此节点不是最终层节点时，递归调用此方法
            if(!"10" .equals(productTree.getIsFinalNode())){
                JSONArray treeNodeJsonArray = productTreeList(company,businessLine,productTree.getId());
                if(!treeNodeJsonArray.isEmpty()){
                    jsonObject.put("children",treeNodeJsonArray);
                }
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }


    /**
     * @Description: 查找某一节点的子节点
     * @param company 公司
     * @param businessLine 业务条线
     * @param parentId 父节点id
     * @return List<ProductTreeEntity> 产品树实体列表
     */
    private List<ProductTreeEntity> childTreeNodeSelect(Long company,Long businessLine,Long parentId){
        ProductTreeEntity productTreeEntity = new ProductTreeEntity();
        productTreeEntity.setCompany(company);
        productTreeEntity.setBusinessLine(businessLine);
        productTreeEntity.setParentId(parentId);
        return dao.select(productTreeEntity);
    }

    /**
     * 根据节点性质不同 显示不同的操作按钮
     * @param productTreeEntity
     * @return
     */
    private String showButton(ProductTreeEntity productTreeEntity){
        String showButton = "";
        //1. 最底层根节点 操作:【添加子节点】
        if(Integer.valueOf(BusinessEnum.ROOT_NODE_LEVEL_NUMBER.getCode()) == productTreeEntity.getLevelNumber()
                && Long.valueOf(BusinessEnum.NOT_FINAL_NODE.getCode()) == productTreeEntity.getIsFinalNode()){
            showButton = BusinessEnum.BUTTON_ADD_NODE.getCode();
            return showButton;
        }
        //2.叶子节点 操作:【删除节点】
        if(Long.valueOf(BusinessEnum.FINAL_NODE.getCode()).equals(productTreeEntity.getIsFinalNode())){
            showButton = BusinessEnum.BUTTON_DEL_NODE.getCode();
            return showButton;
        }
        List<ProductEntity> products =  productBizz.getProductByNode(productTreeEntity.getId());
        List<FinanceProjectEntity> projects = projectBizz.getProjectByNode(productTreeEntity.getId());
        //3.根节点 未关联金融产品或金融专案 操作:【添加子节点】、【删除节点】
        if((null == products || products.isEmpty()) && (null == projects || projects.isEmpty())){
            showButton = BusinessEnum.BUTTON_ADD_DEL_NODE.getCode();
        }else if((null != products && !products.isEmpty()) && (null != projects && !projects.isEmpty())){
            //4.根节点 关联金融产品或者金融专案 操作:【添加节点】
            showButton = BusinessEnum.BUTTON_ADD_NODE.getCode();
        }
        return showButton;
    }

    /**
     * @Description 节点添加 根节点默认生成 所以不需要对根节点判断
     * @param productTreeDto 产品树dto
     */
    public void nodeAdd(ProductTreeDto productTreeDto){
        productTreeDto.setFlag(Long.valueOf(BusinessEnum.EFFECTIVE_FLAG.getCode()));
        Long id = this.create(productTreeDto);
        if(null != id || id <= 0 ){
            throw new CommonBizzException(ServiceResponseEnum.ADD_FAIL);
        }
    }

    /**
     * @Description 节点删除
     * @param productTreeDto 产品树dto
     */
    public void nodeDel(ProductTreeDto productTreeDto){

        //1. 校验必填参数 节点id 层级编号 是否最终节点
        delParamCheck(productTreeDto);
        //2. 最底层根节点不能删除
        if(Integer.valueOf(BusinessEnum.ROOT_NODE_LEVEL_NUMBER.getCode()) == productTreeDto.getLevelNumber()
                && Long.valueOf(BusinessEnum.NOT_FINAL_NODE.getCode()) == productTreeDto.getIsFinalNode()){
            throw new CommonBizzException(ServiceResponseEnum.CAN_NOT_DELETE);
        }
        //3. 节点存下分支节点 不能删除
        isExistNode(productTreeDto);
        //4. 节点下存在产品、金融专案不能被删除

    }

    private void delParamCheck(ProductTreeDto productTreeDto){
        if(null == productTreeDto.getIsFinalNode() || null == productTreeDto.getId() || null == productTreeDto.getLevelNumber()){
            throw new CommonBizzException(ServiceResponseEnum.PARAM_ERROR);
        }
    }

    /**
     * 该节点下是否存在分支节点
     * @param productTreeDto
     */
    private void isExistNode(ProductTreeDto productTreeDto){
        ProductTreeEntity productTreeEntity = new ProductTreeEntity();
        productTreeEntity.setParentId(productTreeDto.getParentId());
        productTreeEntity.setFlag(Long.valueOf(BusinessEnum.EFFECTIVE_FLAG.getCode()));
        List<ProductTreeEntity> productTrees = dao.select(productTreeEntity);
        if(null != productTrees && productTrees.size() > 0){
            throw new CommonBizzException(ServiceResponseEnum.CAN_NOT_DELETE);
        }
    }

    private void isExistProduct(ProductTreeDto productTreeDto){

    }



}
