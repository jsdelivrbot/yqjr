package com.yqjr.fin.scfw.isomer.api.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * @description: 租赁公司事先动支单据详细数据
 * @author: lixue
 * @date: 2018/06/08 14:24:43
 **/
public class FyzlDynamicBillDetailModel {

    //业务明细标识
    private String detailId;

    //渠道
    private String dim03;

    //财务事项
    private String dimAccount;

    //预算承担部门
    private String dimSubject;

    //IT项目
    @XmlElement(name = "ITproject")
    private String iTproject;

    //摘要
    private String memo;

    //预留字段
    private String memo1;

    //预留字段
    private String memo2;

    //金额
    private String naturalCurrency;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getDim03() {
        return dim03;
    }

    public void setDim03(String dim03) {
        this.dim03 = dim03;
    }

    public String getDimAccount() {
        return dimAccount;
    }

    public void setDimAccount(String dimAccount) {
        this.dimAccount = dimAccount;
    }

    public String getDimSubject() {
        return dimSubject;
    }

    public void setDimSubject(String dimSubject) {
        this.dimSubject = dimSubject;
    }

    public String getiTproject() {
        return iTproject;
    }

    public void setiTproject(String iTproject) {
        this.iTproject = iTproject;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public String getNaturalCurrency() {
        return naturalCurrency;
    }

    public void setNaturalCurrency(String naturalCurrency) {
        this.naturalCurrency = naturalCurrency;
    }
}
