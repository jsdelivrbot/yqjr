package com.yqjr.fin.pvc.core.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "PF_TEMP_TABALE1")
public class TempTabale1 extends BaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @Id
    @KeySql(sql = "select SEQ_PF_TEMP_TABALE1.nextval from dual", order = ORDER.BEFORE)
    private Long id;


    /**
     * 申请编号
     */
    private Long applyId;


    /**
     * 客户姓名
     */
    private String customerName;


    /**
     * 申请日期
     */
    private java.util.Date applyDate;
    

    /**
     * 贷款金额
     */
    private java.math.BigDecimal loanMoney;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
