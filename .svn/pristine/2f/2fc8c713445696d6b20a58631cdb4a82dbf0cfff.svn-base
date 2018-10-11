package com.yqjr.fin.cvc.core.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "TK_APPLYBASIC")
public class TkApplybasic extends BaseMapperEntity<Long> {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @Id
    @KeySql(sql = "select SEQ_TK_APPLYBASIC.nextval from dual", order = ORDER.BEFORE)
    private Long id;


    /**
     * 客户id
     */
    private Long ncustomerid;


    /**
     * 合同号
     */
    private String vbargainno;


    /**
     * 经销商编号
     */
    private String vdealerno;


    /**
     * 车队id
     */
    private Long ntruckteamid;


    /**
     * 贷款金额
     */
    private java.math.BigDecimal nloanmoney;


    /**
     * 计息方式
     */
    private Long ngetinteresttype;


    /**
     * 期限
     */
    private Long ntimelimit;


    /**
     * 每期还款日
     */
    private Long npayday;


    /**
     * 银联编号
     */
    private String vunionpayno;


    /**
     * 扣划卡号
     */
    private String vdeductbankcardno;


    /**
     * 央行基准利率
     */
    private java.math.BigDecimal nbenchmarkrate;


    /**
     * 利率上浮比例
     */
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
    private Long nmanageuserid;


    /**
     * 录入时间
     */
    private java.util.Date dsystime;
    

    /**
     * 有效状态
     */
    private String vstatus;


    /**
     * 扣划方式
     */
    private Long ndeducttype;


    /**
     * 扣划行
     */
    private Long ndeductbank;


    /**
     * 状态
     */
    private Long napplystatus;


    /**
     * 阶段
     */
    private Long napplyphase;


    /**
     * 合同签订人
     */
    private String vcontractsigner;


    /**
     * 合同录入人
     */
    private Long ninputuserid;


    /**
     * nissysdefault
     */
    private Long nissysdefault;


    /**
     * 利率调整方式
     */
    private Long nrateadjusttype;


    /**
     * 利率
     */
    private java.math.BigDecimal ninterestrate;


    /**
     * 实际客户类型，核心客户or普通客户
     */
    private Long nrealcustomertype;


    /**
     * 申请客户类型，核心客户or普通客户
     */
    private Long napplycustomertype;


    /**
     * 二纬码（预留）
     */
    private String vbarcode;


    /**
     * 产品id
     */
    private Long nproductid;


    /**
     * 央行基准利率日期
     */
    private java.util.Date dbenchmarkratedate;
    

    /**
     * ntotalprice
     */
    private Long ntotalprice;


    /**
     * 调查任务处理人（经销商）
     */
    private Long ninvestuserid;


    /**
     * vcardholder
     */
    private String vcardholder;


    /**
     * vunipayidtype
     */
    private String vunipayidtype;


    /**
     * vunipayidno
     */
    private String vunipayidno;


    /**
     * vunipaybankname
     */
    private String vunipaybankname;


    /**
     * 预留尾款
     */
    private java.math.BigDecimal nleavemoney;


    /**
     * 抵押前放款政策 2 抵押前放款
     */
    private Long nmorgatetype;


    /**
     * 未抵押是否可以放款 0 不可以，1是
     */
    private Long nisunmorgatecanloan;


    /**
     * 客户利率
     */
    private java.math.BigDecimal ncustrate;


    /**
     * 大客户id
     */
    private Long nbigcustomerid;


    /**
     * 缓冲信贷月份1
     */
    private Long nhcmonthf;


    /**
     * 缓冲信贷月份2
     */
    private Long nhcmonths;


    /**
     * 人脸识别状态。1为成功
     */
    private Long nfacestatus;


    /**
     * 来源.1是APP,2是DSP,默认为2
     */
    private Long channel;


    /**
     * 前端缓冲期
     */
    private Long nfronterm;


    /**
     * 中间缓冲期
     */
    private Long nmidterm;


    /**
     * 中间缓冲起始期
     */
    private Long nmidtermth;


    /**
     * 特殊抵押期限
     */
    private Long nunmorgatecanloanlimit;


    /**
     * updateTime
     */
    private java.util.Date updateTime;
    

    /**
     * createTime
     */
    private java.util.Date createTime;
    

    /**
     * updateBy
     */
    private Long updateBy;


    /**
     * createBy
     */
    private Long createBy;

   
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
