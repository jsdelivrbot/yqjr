package com.yqjr.fin.rems.rule.bizz;

import com.yqjr.fin.rems.rule.entity.VerifySubruleHisEntity;
import com.yqjr.fin.rems.rule.dao.VerifySubruleHisDao;
import com.yqjr.fin.rems.rule.dto.VerifySubruleHisDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
*  验证型子规则轨迹表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Service
@Transactional(readOnly = true)
public class VerifySubruleHisBizz extends BaseMapperBizz<VerifySubruleHisDao, VerifySubruleHisEntity, Long,VerifySubruleHisDto> {
	
}