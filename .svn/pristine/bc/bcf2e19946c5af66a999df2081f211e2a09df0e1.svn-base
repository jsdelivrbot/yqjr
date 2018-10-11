package com.yqjr.fin.rems.rule.bizz;

import com.ritoinfo.framework.evo.common.uitl.BeanUtil;
import com.ritoinfo.framework.evo.sp.base.model.Page;
import com.ritoinfo.framework.evo.sp.base.model.PageList;
import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.BusinessException;
import com.yqjr.fin.common.base.starter.exception.CommonBizzException;
import com.yqjr.fin.rems.rule.condition.RuleFactorTypeCondition;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import com.yqjr.fin.rems.rule.entity.RuleFactorEntity;
import com.yqjr.fin.rems.rule.entity.RuleFactorTypeEntity;
import com.yqjr.fin.rems.rule.dao.RuleFactorTypeDao;
import com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto;
import com.yqjr.fin.rems.rule.exception.RuleBizzException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
import sun.rmi.runtime.Log;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
*  规则因子类型表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Slf4j
@Service
@Transactional(readOnly = true)
public class RuleFactorTypeBizz extends BaseMapperBizz<RuleFactorTypeDao, RuleFactorTypeEntity, Long,RuleFactorTypeDto> {

    /**
     * @Description: 规则因子类型名称唯一性验证
     * @Author zengxiaoran
     * @Date 2018/8/31 11:14
     * @Param [factorTypeName]
     * @Return com.ritoinfo.framework.evo.sp.base.model.ServiceResponse<com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto>
     */
    public void validateTypeName(String typeName){
        RuleFactorTypeEntity ruleFactorTypeEntity = new RuleFactorTypeEntity();
        ruleFactorTypeEntity.setTypeName(typeName);
        List<RuleFactorTypeEntity>ruleFactorTypeEntities =
                dao.select(ruleFactorTypeEntity);
        if (ruleFactorTypeEntities.size()>0 && ruleFactorTypeEntities!=null){
            throw new CommonBizzException(ServiceResponseEnum.NAME_ALREADY_EXIST.getMessage());
        }
    }

    /**
     * @Description: 规则因子类型新增
     * @Author zengxiaoran
     * @Date 2018/8/31 11:06
     * @Param [ruleFactorTypeDto]
     * @Return com.ritoinfo.framework.evo.sp.base.model.ServiceResponse<com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto>
     */
    public void addFactorType(RuleFactorTypeDto ruleFactorTypeDto){
            create(ruleFactorTypeDto);
    }


    /**
     * @Description: 规则因子类型修改
     * @Author zengxiaoran
     * @Date 2018/8/31 14:16
     * @Param [ruleFactorTypeDto]
     * @Return com.ritoinfo.framework.evo.sp.base.model.ServiceResponse<com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto>
     */
    public void updateFactorType(RuleFactorTypeDto ruleFactorTypeDto){
            RuleFactorTypeEntity ruleFactorTypeEntity = new RuleFactorTypeEntity();
            BeanUtil.copy(ruleFactorTypeEntity,ruleFactorTypeDto);
            ruleFactorTypeEntity.setExplain(ruleFactorTypeDto.getExplain());
            Example example = new Example(ruleFactorTypeEntity.getClass(),true);
            example.createCriteria().andEqualTo("id",ruleFactorTypeEntity.getId());
            dao.updateByExampleSelective(ruleFactorTypeEntity,example);
    }

    /**
     * @Description: 规则因子类型删除
     * @Author zengxiaoran
     * @Date 2018/9/3 15:52
     * @Param [factorTypeId]
     * @Return void
     */
    @Autowired
    RuleFactorBizz ruleFactorBizz;
    public void deleteFactorType(Long factorTypeId){
        Example example1 = new Example(RuleFactorEntity.class);
        example1.createCriteria().andEqualTo("factorTypeId",factorTypeId);
        List<RuleFactorDto> ruleFactorDtos = ruleFactorBizz.find(example1);
        if (ruleFactorDtos.size()>0 && ruleFactorDtos!=null){
            throw new CommonBizzException(ServiceResponseEnum.DELETE_FAIL.getMessage());
        }else {
            RuleFactorTypeEntity ruleFactorTypeEntity = dao.selectByPrimaryKey(factorTypeId);
            ruleFactorTypeEntity.setFlag(0L);
            Example example = new Example(ruleFactorTypeEntity.getClass(),true);
            example.createCriteria().andEqualTo("id",ruleFactorTypeEntity.getId());
            dao.updateByExampleSelective(ruleFactorTypeEntity,example);
        }
    }

    /**
     * @Description:规则因子类型分页查询
     * @Author zengxiaoran
     * @Date 2018/9/3 9:05
     * @Param [condition]
     * @Return com.ritoinfo.framework.evo.sp.base.model.ServiceResponse<com.ritoinfo.framework.evo.sp.base.model.PageList<com.yqjr.fin.rems.rule.dto.RuleFactorTypeDto>>
     */
    public PageList<RuleFactorTypeDto>findByPage(
            RuleFactorTypeCondition condition){
        PageList<RuleFactorTypeDto> pageList = findPage(condition);
        return  pageList;
    }
}