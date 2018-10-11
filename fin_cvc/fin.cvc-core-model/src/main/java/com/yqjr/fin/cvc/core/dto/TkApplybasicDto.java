package com.yqjr.fin.cvc.core.dto;

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
public class TkApplybasicDto implements Serializable {


    private static final long serialVersionUID = 1L;


    /**
     * id
     */
     @NotNull(groups=UpdateGroup.class)
     private Long id;

    /**
     * 客户id
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ncustomerid;

    

    /**
     * 合同号
     */
    @Size(min = 0, max = 50,groups=CreateGroup.class)
    private String vbargainno;

    

    /**
     * 经销商编号
     */
    @Size(min = 0, max = 20,groups=CreateGroup.class)
    private String vdealerno;

    

    /**
     * 车队id
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ntruckteamid;

    

    /**
     * 贷款金额
     */
    @Digits(integer =16,fraction=2,groups=CreateGroup.class)
    private java.math.BigDecimal nloanmoney;

    

    /**
     * 计息方式
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ngetinteresttype;

    

    /**
     * 期限
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ntimelimit;

    

    /**
     * 每期还款日
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long npayday;

    

    /**
     * 银联编号
     */
    @Size(min = 0, max = 30,groups=CreateGroup.class)
    private String vunionpayno;

    

    /**
     * 扣划卡号
     */
    @Size(min = 0, max = 30,groups=CreateGroup.class)
    private String vdeductbankcardno;

    

    /**
     * 央行基准利率
     */
    @Digits(integer =14,fraction=4,groups=CreateGroup.class)
    private java.math.BigDecimal nbenchmarkrate;

    

    /**
     * 利率上浮比例
     */
    @Digits(integer =14,fraction=4,groups=CreateGroup.class)
    private java.math.BigDecimal nfloatingratepercent;

    

    /**
     * 申请日期
     */
    private java.util.Date dapplydate;

    

    /**
     * 合同签订日期
     */
    private java.util.Date dbegindate;

    

    /**
     * 预计结束日期
     */
    private java.util.Date denddate;

    

    /**
     * 实际放款日
     */
    private java.util.Date dfactstartdate;

    

    /**
     * 实际结束日
     */
    private java.util.Date dfactenddate;

    

    /**
     * 客户经理
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nmanageuserid;

    

    /**
     * 录入时间
     */
    private java.util.Date dsystime;

    

    /**
     * 有效状态
     */
    @Size(min = 0, max = 20,groups=CreateGroup.class)
    private String vstatus;

    

    /**
     * 扣划方式
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ndeducttype;

    

    /**
     * 扣划行
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ndeductbank;

    

    /**
     * 状态
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long napplystatus;

    

    /**
     * 阶段
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long napplyphase;

    

    /**
     * 合同签订人
     */
    @Size(min = 0, max = 30,groups=CreateGroup.class)
    private String vcontractsigner;

    

    /**
     * 合同录入人
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ninputuserid;

    

    /**
     * nissysdefault
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nissysdefault;

    

    /**
     * 利率调整方式
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nrateadjusttype;

    

    /**
     * 利率
     */
    @Digits(integer =14,fraction=4,groups=CreateGroup.class)
    private java.math.BigDecimal ninterestrate;

    

    /**
     * 实际客户类型，核心客户or普通客户
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nrealcustomertype;

    

    /**
     * 申请客户类型，核心客户or普通客户
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long napplycustomertype;

    

    /**
     * 二纬码（预留）
     */
    @Size(min = 0, max = 30,groups=CreateGroup.class)
    private String vbarcode;

    

    /**
     * 产品id
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nproductid;

    

    /**
     * 央行基准利率日期
     */
    private java.util.Date dbenchmarkratedate;

    

    /**
     * ntotalprice
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ntotalprice;

    

    /**
     * 调查任务处理人（经销商）
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long ninvestuserid;

    

    /**
     * vcardholder
     */
    @Size(min = 0, max = 30,groups=CreateGroup.class)
    private String vcardholder;

    

    /**
     * vunipayidtype
     */
    @Size(min = 0, max = 20,groups=CreateGroup.class)
    private String vunipayidtype;

    

    /**
     * vunipayidno
     */
    @Size(min = 0, max = 200,groups=CreateGroup.class)
    private String vunipayidno;

    

    /**
     * vunipaybankname
     */
    @Size(min = 0, max = 200,groups=CreateGroup.class)
    private String vunipaybankname;

    

    /**
     * 预留尾款
     */
    @Digits(integer =16,fraction=2,groups=CreateGroup.class)
    private java.math.BigDecimal nleavemoney;

    

    /**
     * 抵押前放款政策 2 抵押前放款
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nmorgatetype;

    

    /**
     * 未抵押是否可以放款 0 不可以，1是
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nisunmorgatecanloan;

    

    /**
     * 客户利率
     */
    @Digits(integer =14,fraction=4,groups=CreateGroup.class)
    private java.math.BigDecimal ncustrate;

    

    /**
     * 大客户id
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nbigcustomerid;

    

    /**
     * 缓冲信贷月份1
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nhcmonthf;

    

    /**
     * 缓冲信贷月份2
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nhcmonths;

    

    /**
     * 人脸识别状态。1为成功
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nfacestatus;

    

    /**
     * 来源.1是APP,2是DSP,默认为2
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long channel;

    

    /**
     * 前端缓冲期
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nfronterm;

    

    /**
     * 中间缓冲期
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nmidterm;

    

    /**
     * 中间缓冲起始期
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nmidtermth;

    

    /**
     * 特殊抵押期限
     */
    @Digits(integer =22,fraction=0,groups=CreateGroup.class)
    private Long nunmorgatecanloanlimit;

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}