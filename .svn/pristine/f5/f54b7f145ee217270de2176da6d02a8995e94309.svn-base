package com.yqjr.fin.pvc.core.dto;

import lombok.Data;
import lombok.ToString;

import com.ritoinfo.framework.evo.sp.base.starter.validate.group.CreateGroup;
import com.ritoinfo.framework.evo.sp.base.starter.validate.group.UpdateGroup;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;

@Data
@ToString
public class TempTabale1Dto implements Serializable {


    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
     @NotNull(groups=UpdateGroup.class)
     private Long id;

    /**
     * 申请编号
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long applyId;

    

    /**
     * 客户姓名
     */
    @Size(min = 0, max = 200,groups=CreateGroup.class)
    private String customerName;

    

    /**
     * 申请日期
     */
    private java.util.Date applyDate;

    

    /**
     * 贷款金额
     */
    @Digits(integer =16,fraction=2,groups=CreateGroup.class)
    private java.math.BigDecimal loanMoney;

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}