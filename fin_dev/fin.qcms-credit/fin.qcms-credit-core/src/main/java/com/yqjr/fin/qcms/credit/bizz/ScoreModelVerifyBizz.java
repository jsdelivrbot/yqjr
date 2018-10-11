package com.yqjr.fin.qcms.credit.bizz;

import com.yqjr.fin.qcms.credit.entity.ScoreModelVerify;
import com.yqjr.fin.qcms.credit.dao.ScoreModelVerifyDao;
import com.yqjr.fin.qcms.credit.dto.ScoreModelVerifyDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ritoinfo.framework.evo.sp.base.starter.bizz.BaseMapperBizz;
/**
* 评分卡模型验证表逻辑处理层，该类为小的Bizz类,
* 只简单操作对应的Dao（持久）层方法，
* 具体业务由大的Bizz类实现
* @Author:         zxd
* @CreateDate:     2018-08-27 10:30:42
*/
@Service
@Transactional(readOnly = true)
public class ScoreModelVerifyBizz extends BaseMapperBizz<ScoreModelVerifyDao, ScoreModelVerify, Long,ScoreModelVerifyDto> {
	
}