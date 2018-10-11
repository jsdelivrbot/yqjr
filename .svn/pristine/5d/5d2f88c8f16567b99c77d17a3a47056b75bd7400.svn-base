package com.yqjr.fin.rems.rule.bizz;

import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.BusinessEnum;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.rems.rule.condition.RuleFactorCondition;
import com.yqjr.fin.rems.rule.entity.AssignSubruleEntity;
import com.yqjr.fin.rems.rule.entity.RuleFactorEntity;
import com.yqjr.fin.rems.rule.dao.RuleFactorDao;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 规则因子主表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Slf4j
@Service
@Transactional(readOnly = true)
public class RuleFactorBizz extends BaseMapperBizz<RuleFactorDao, RuleFactorEntity, Long,RuleFactorDto> {


    @Autowired
    AssignSubruleBizz assignSubruleBizz;

    @Autowired
    VerifySubruleBizz verifySubruleBizz;
  
    /** 
     * @Author: lixue
     * @Description: 规则因子名称重复性验证
     * @Date: 13:09 2018/8/28
     * @params: factorName 规则因子名称
     * 
     */
    public void nameValid(String factorName) {
        RuleFactorEntity ruleFactorEntity = new RuleFactorEntity();
        ruleFactorEntity.setFactorName(factorName);
        List<RuleFactorEntity> ruleFactorList = dao.select(ruleFactorEntity);
        if(null != ruleFactorList && ruleFactorList.size()>0){
            throw new CommonBizzException(ServiceResponseEnum.NAME_ALREADY_EXIST);
        }
    }

    /**
     * @Author: lixue
     * @Description: 规则因子代码重复性验证
     * @Date: 2018/8/28 13:09
     * @params: factorCode 规则因子代码
     *
     */
    public void codeValid(String factorCode) {
        RuleFactorEntity ruleFactorEntity = new RuleFactorEntity();
        ruleFactorEntity.setFactorName(factorCode);
        List<RuleFactorEntity> ruleFactorList = dao.select(ruleFactorEntity);
        if(null != ruleFactorList && ruleFactorList.size()>0){
            throw new CommonBizzException(ServiceResponseEnum.CODE_ALREADY_EXIST);
        }
    }


    /**
     * @Author: lixue
     * @Description: 规则因子增加
     * @Date: 2018/8/28 14:14
     * @params: ruleFactorDto 规则因子dto
     * @returns:
     *
     */
    public void add(RuleFactorDto ruleFactorDto){
        ruleFactorDto.setFlag(Integer.valueOf(BusinessEnum.EFFECTIVE_FLAG.getCode()));
        Long id = this.create(ruleFactorDto);
        if(null == id || id <= 0){
            throw new CommonBizzException(ServiceResponseEnum.ADD_FAIL);
        }
    }

    /**
     * @Author: lixue
     * @Description: 规则因子分页
     * @Date: 2018/8/28 14:14
     * @params: ruleFactorDto 规则因子dto
     * @returns:
     *
     */
    public PageList<RuleFactorDto> page(RuleFactorCondition ruleFactorCondition){
        PageList<RuleFactorDto> ruleFactorPageList = this.findPage(ruleFactorCondition);
        if(null == ruleFactorPageList || ruleFactorPageList.getTotalPage() == 0 ){
            throw new CommonBizzException(ServiceResponseEnum.NO_QUERY_RESULT);
        }
        return ruleFactorPageList;
    }

    /**
     * @Author: lixue
     * @Description: 规则因子修改 只有说明可修改
     * @Date: 2018/8/28 14:14
     * @params: ruleFactorDto 规则因子dto
     * @returns:
     *
     */
    public void ruleFactorUpdate(RuleFactorDto ruleFactorDto){
        RuleFactorEntity ruleFactorEntity = new RuleFactorEntity();
        ruleFactorEntity.setId(ruleFactorDto.getId());
        ruleFactorEntity.setExplain(ruleFactorDto.getExplain());
        if(dao.updateByPrimaryKeySelective(ruleFactorEntity)< 0 ){
            throw new CommonBizzException(ServiceResponseEnum.UPDATE_FAIL);
        }
    }

    /**
     * @Author: lixue
     * @Description:  规则因子删除
     * @Date:  2018/8/29 8:44
     * @params: ruleFactorId 规则因子id
     *
     */
    public ServiceResponse<RuleFactorDto> ruleFactorDelete(Long ruleFactorId){
        //TODO 是否做正在使用的判断待确定
        List<AssignSubruleEntity> assignSubruleList = assignSubruleBizz.selectByFactorId(ruleFactorId);
        return null;
    }


    /**
     * @Author: lixue
     * @Description:  获取不同公司的规则因子列表 1 金融 2 租赁
     * @Date:  2018/8/29 8:44
     * @params: company 公司
     *
     */
    public List<RuleFactorDto> ruleFactorList(Long company){
        String typeAttribute = "";
        // 金融公司：获取类型属性为公共+金融的规则因子列表 租赁公司：获取类型属性为公共+租赁的规则因子列表
        if(Long.valueOf(BusinessEnum.FIN_COMPANY.getCode()) == company){ // 金融公司
            typeAttribute = BusinessEnum.COMMON_TYPE_ATTRIBUTE.getCode()+","+BusinessEnum.FIN_TYPE_ATTRIBUTE.getCode();
        }else if(Long.valueOf(BusinessEnum.RENT_COMPANY.getCode()) == company){//租赁公司
            typeAttribute = BusinessEnum.COMMON_TYPE_ATTRIBUTE.getCode()+","+BusinessEnum.RENT_TYPE_ATTRIBUTE.getCode();
        }else{
            throw new CommonBizzException(ServiceResponseEnum.NO_COMPANY);
        }
        Map<String,Object> parmaMap = new HashMap<>();
        parmaMap.put("flag",BusinessEnum.EFFECTIVE_FLAG.getCode());
        parmaMap.put("typeAttributes",typeAttribute.split(","));
        return dao.selectByTypeAttribute(parmaMap);
    }


}