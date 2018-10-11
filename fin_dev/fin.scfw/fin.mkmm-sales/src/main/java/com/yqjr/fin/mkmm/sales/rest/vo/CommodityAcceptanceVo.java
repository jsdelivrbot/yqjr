package com.yqjr.fin.mkmm.sales.rest.vo;

import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;

import java.math.BigDecimal;


/**
 * Created by fannaian on 2018/09/04
 */
public class CommodityAcceptanceVo extends CommodityAcceptance{

    /**
     * 单价
     */
    private BigDecimal inUnivalent;
    /**
     * 总金额
     */
    private BigDecimal amount;

    public BigDecimal getInUnivalent() {
        return inUnivalent;
    }

    public void setInUnivalent(BigDecimal inUnivalent) {
        this.inUnivalent = inUnivalent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
