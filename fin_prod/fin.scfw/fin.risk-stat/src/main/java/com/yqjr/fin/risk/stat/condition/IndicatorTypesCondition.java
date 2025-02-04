package com.yqjr.fin.risk.stat.condition;

import com.yqjr.fin.risk.stat.entity.IndicatorTypes;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

public class IndicatorTypesCondition extends BaseCondition<IndicatorTypes, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/indicatorTypes/list
     *表单维护路径：/indicatorTypes/form
     *
     */

    /**
     * 序列号
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 指标类型
     */
    @Length(min = 0, max = 3)
    private java.lang.String code;

    /**
     * 指标类型代码
     */
    @Length(min = 0, max = 100)
    private java.lang.String name;

    /**
     * 备注
     */
    @Length(min = 0, max = 100)
    private java.lang.String remark;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}