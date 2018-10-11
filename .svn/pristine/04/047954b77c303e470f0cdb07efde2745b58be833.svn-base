package com.yqjr.fin.fpms.product.bizz.gateway;

import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.yqjr.fin.rems.rule.api.RuleFactorApi;
import com.yqjr.fin.rems.rule.dto.RuleFactorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: 规则导入业务层
 * @author: lixue
 * @date: 2018/08/29 16:10:23
 **/
@Service
@Transactional(readOnly = true)
public class RuleImportBizz {

    @Autowired
    RuleFactorApi ruleFactorApi;

    public ServiceResponse<List<RuleFactorDto>> ruleFactorDtoList(Long company){
        return ruleFactorApi.ruleFactorList(company);
    }

}
