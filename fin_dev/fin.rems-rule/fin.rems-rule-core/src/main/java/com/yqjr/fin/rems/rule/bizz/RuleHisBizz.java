package com.yqjr.fin.rems.rule.bizz;

import com.yqjr.fin.rems.rule.entity.RuleHisEntity;
import com.yqjr.fin.rems.rule.dao.RuleHisDao;
import com.yqjr.fin.rems.rule.dto.RuleHisDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
*  规则轨迹表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Service
@Transactional(readOnly = true)
public class RuleHisBizz extends BaseMapperBizz<RuleHisDao, RuleHisEntity, Long,RuleHisDto> {
	
}