package com.yqjr.fin.rems.rule.bizz;

import com.yqjr.fin.rems.rule.entity.AssignSubruleEntity;
import com.yqjr.fin.rems.rule.dao.AssignSubruleDao;
import com.yqjr.fin.rems.rule.dto.AssignSubruleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;

import java.util.List;

/**
* 赋值型子规则表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 13:04:32
*/
@Service
@Transactional(readOnly = true)
public class AssignSubruleBizz extends BaseMapperBizz<AssignSubruleDao, AssignSubruleEntity, Long,AssignSubruleDto> {

    /** 
     * @Author: lixue
     * @Description:  根据规则因子id查询赋值型子规则信息
     * @Date:  2018/8/29 9:04
     * @params: 
     * @returns: 
     * 
     */
    public List<AssignSubruleEntity> selectByFactorId(Long ruleFactorId){
        AssignSubruleEntity assignSubruleEntity = new AssignSubruleEntity();
        assignSubruleEntity.setRuleFactorId(ruleFactorId);
        List<AssignSubruleEntity> assignSubruleList = dao.select(assignSubruleEntity);
        //dao.selectByExample();
        return assignSubruleList;
    }
}