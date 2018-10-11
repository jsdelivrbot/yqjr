package com.yqjr.fin.qcms.credit.bizz;

import com.yqjr.fin.qcms.credit.entity.PolicyRule;
import com.yqjr.fin.qcms.credit.dao.PolicyRuleDao;
import com.yqjr.fin.qcms.credit.dto.PolicyRuleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
* 政策规则关系表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:41
*/
@Service
@Transactional(readOnly = true)
public class PolicyRuleBizz extends BaseMapperBizz<PolicyRuleDao, PolicyRule, Long,PolicyRuleDto> {
	
}