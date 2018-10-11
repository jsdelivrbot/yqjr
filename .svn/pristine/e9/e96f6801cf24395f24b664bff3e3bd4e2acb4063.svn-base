package com.yqjr.fin.fpms.product.bizz;

import com.ritoinfo.framework.evo.common.uitl.BeanUtil;
import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.yqjr.fin.common.base.starter.enums.ConstantsEnum;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.fpms.product.condition.ProductCondition;
import com.yqjr.fin.fpms.product.dto.ProductAuditFlowDto;
import com.yqjr.fin.fpms.product.dto.ProductTreeDto;
import com.yqjr.fin.fpms.product.entity.ProductEntity;
import com.yqjr.fin.fpms.product.dao.ProductDao;
import com.yqjr.fin.fpms.product.dto.ProductDto;

import com.yqjr.fin.fpms.product.entity.ProductTreeEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 金融产品主表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 10:49:56
*/
@Service
@Slf4j
@Transactional(readOnly = true)
public class ProductBizz extends BaseMapperBizz<ProductDao, ProductEntity, Long,ProductDto> {
    /**
     * @Description:金融产品名称唯一性验证
     * @Author zengxiaoran
     * @Date 2018/9/3 16:02
     * @Param [productName]
     * @Return void
     */
    public void validateName(String productName){
        Example example = new Example(ProductEntity.class);
        example.createCriteria().andEqualTo("vname",productName);
        List<ProductEntity> productEntitylist = dao.selectByExample(example);
        if(productEntitylist.size()>0 || productEntitylist!=null){
            throw new CommonBizzException(ServiceResponseEnum.NAME_ALREADY_EXIST.getMessage());
        }
    }


    /**
     * @Description:金融产品基本信息新增
     * @Author zengxiaoran
     * @Date 2018/9/3 10:24
     * @Param [productDto]
     * @Return void
     */
    public void addProduct(ProductDto productDto){
        productDto.setExamineStatusCode(ConstantsEnum.BEFORE_EXAMINE.getCode());
        productDto.setExamineStatusName(ConstantsEnum.BEFORE_EXAMINE.getMessage());
        create(productDto);
    }

    /**
     * @Description:金融产品基本信息展示
     * @Author zengxiaoran
     * @Date 2018/9/5 10:26
     * @Param [productId]
     * @Return com.yqjr.fin.fpms.product.dto.ProductDto
     */
    public ProductDto showInfo(Long productId){
        ProductEntity productEntity = dao.selectByPrimaryKey(productId);
        ProductDto productDto = new ProductDto();
        BeanUtil.copy(productDto,productEntity);
        return productDto;
    }

    /**
     * @Description:金融产品删除
     * @Author zengxiaoran
     * @Date 2018/9/3 10:53
     * @Param [productDto]
     * @Return void
     */
    public void deleteProduct(Long id){
        ProductEntity productEntity = dao.selectByPrimaryKey(id);
        ProductDto productDto = new ProductDto();
        BeanUtil.copy(productDto,productEntity);
        Long examineStatusCode =  productDto.getExamineStatusCode();
        if (examineStatusCode==ConstantsEnum.REJECT_EXAMINE.getCode()||
                examineStatusCode==ConstantsEnum.BEFORE_EXAMINE.getCode()){
            productEntity.setFlag(ConstantsEnum.INVALID_FLAG.getCode());//状态设置为0,无效
            Example example = new Example(productEntity.getClass(),true);
            example.createCriteria().andEqualTo("id",productEntity.getId());
            dao.updateByExampleSelective(productEntity,example);
        } else {
            throw new CommonBizzException(ServiceResponseEnum.DELETE_FAIL.getMessage());
        }
    }

    /**
     * @Description:金融产品修改
     * @Author zengxiaoran
     * @Date 2018/9/3 15:59
     * @Param [productDto]
     * @Return void
     */
    public void updateProduct(ProductDto productDto){
        ProductEntity productEntity = dao.selectByPrimaryKey(productDto.getId());
        Long examineStatusCode =  productDto.getExamineStatusCode();
        if (examineStatusCode==ConstantsEnum.REJECT_EXAMINE.getCode()||
                examineStatusCode==ConstantsEnum.BEFORE_EXAMINE.getCode()){
            BeanUtil.copy(productEntity,productDto);
            Example example = new Example(productEntity.getClass());
            example.createCriteria().andEqualTo("id",productEntity.getId());
            dao.updateByExample(productEntity,example);
        }else {
            throw new CommonBizzException(ServiceResponseEnum.UPDATE_FAIL.getMessage());
        }
    }


    /**
     * @Description:金融产品审核状态分页查询
     * @Author zengxiaoran
     * @Date 2018/9/3 16:28
     * @Param [productDto]
     * @Return com.ritoinfo.framework.evo.sp.base.model.PageList<com.yqjr.fin.fpms.product.dto.ProductDto>
     */
    public PageList<ProductDto> findExamineStatus(ProductCondition productCondition){
        return findPage(productCondition);
    }

    /**
     * @Description:金融产品提交审核
     * @Author zengxiaoran
     * @Date 2018/9/5 16:11
     * @Param [productId]
     * @Return void
     */
    @Autowired
    ProductAuditFlowBizz productAuditFlowBizz;
    public void commitAudit(Long productId){
        //根据产品id获得金融产品实体
        ProductEntity productEntity = dao.selectByPrimaryKey(productId);
        ProductDto productDto = new ProductDto();
        BeanUtil.copy(productDto,productEntity);
       //将产品的审核状态修改为待审核
        productDto.setExamineStatusCode(ConstantsEnum.IN_EXAMINE.getCode());
        Example example = new Example(productEntity.getClass());
        example.createCriteria().andEqualTo("id",productId);
        dao.updateByExample(productEntity,example);
        //金融产品审核主表中,插入数据
        ProductAuditFlowDto productAuditFlowDto = new ProductAuditFlowDto();
        productAuditFlowDto.setProductId(productId);
        productAuditFlowDto.setExamineStatusCode(ConstantsEnum.IN_EXAMINE.getCode());
        productAuditFlowBizz.create(productAuditFlowDto);
    }

    /**
     * @Description:金融产品单个附件上传
     * @Author zengxiaoran
     * @Date 2018/9/6 11:22
     * @Param [file]
     * @Return void
     */
    public void uploadOne(MultipartFile file){
        if (file.isEmpty()){
            throw new CommonBizzException(ServiceResponseEnum.FILE_EMPTY.getMessage());
        }
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);
        String filePath = "E://testUpload//";
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description:金融产品多个附件上传
     * @Author zengxiaoran
     * @Date 2018/9/6 13:45
     * @Param [request]
     * @Return void
     */
    public void uploadMore(MultipartFile[] files){
        for (MultipartFile multipartFile : files) {
            uploadOne(multipartFile);
        }
    }


    /**
     * @Description:金融产品关联产品树节点
     * @Author zengxiaoran
     * @Date 2018/9/7 10:23
     * @Param [productId, treeId]
     * @Return void
     */
    @Autowired
    ProductTreeBizz productTreeBizz;
    public void connectNode(Long productId,Long treeId){
       ProductTreeEntity productTreeEntity =  productTreeBizz.findById(treeId);
       Long isFinalNode = productTreeEntity.getIsFinalNode();
       if (isFinalNode==1){
           ProductEntity productEntity = dao.selectByPrimaryKey(productId);
           productEntity.setTreeNodeId(treeId);
           Example example = new Example(productEntity.getClass());
           example.createCriteria().andEqualTo("id",productId);
           dao.updateByExampleSelective(productEntity,example);
       }
    }
}