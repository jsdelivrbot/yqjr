package com.yqjr.fin.rems.rule.condition;
import lombok.Data;
import com.ritoinfo.framework.evo.sp.base.dto.PageDto;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

/**
* 规则因子主表用户交互响应类
* @Author:          lixue
* @CreateDate:     2018-08-27 13:04:33
*/
@Data
public class RuleFactorCondition extends PageDto {


    /**
     *规则因子名称
     */
    private String factorName;

    /**
     *规则因子类型id
     */
    private Long factorTypeId;

    /**
     *规则因子类型名称
     */
    private String factorTypeName;

    /**
     *类型属性编码
     */
    private String typeAttributeCode;

    /**
     *类型属性名称
     */
    private String typeAttributeName;



}
