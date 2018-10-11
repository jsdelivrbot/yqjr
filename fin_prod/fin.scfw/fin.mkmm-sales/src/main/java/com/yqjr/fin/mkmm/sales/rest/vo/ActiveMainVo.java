package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.ActiveMain;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

/**
 * Created by yaoxin on 2018/6/6.
 */
public class ActiveMainVo extends ActiveMain {
    /**
     * 实际活动成交数量
     */
    @Digits(fraction = 22, integer = 0)
    private Long actualTurnoverCount;
    /**
     * 达成率
     */
    @Length(min = 0, max = 20)
    private String reachRate;
    /**
     * 品牌编码
     */
    @Length(min = 0, max = 50)
    private String brandsCode;

    /**
     * 品牌名称
     */
    @Length(min = 0, max = 50)
    private String brandsName;


    /**
     * 结算状态（00-初始，01-未动支，02-动支中，03-已动支）
     */
    @Length(min = 0, max = 20)
    private java.lang.String billStatus;

    /**
     * 系统时间
     */
    private String systemTime;

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public Long getActualTurnoverCount() {
        return actualTurnoverCount;
    }

    public void setActualTurnoverCount(Long actualTurnoverCount) {
        this.actualTurnoverCount = actualTurnoverCount;
    }

    public String getReachRate() {
        return reachRate;
    }

    public void setReachRate(String reachRate) {
        this.reachRate = reachRate;
    }

    public String getBrandsCode() {
        return brandsCode;
    }

    public void setBrandsCode(String brandsCode) {
        this.brandsCode = brandsCode;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}