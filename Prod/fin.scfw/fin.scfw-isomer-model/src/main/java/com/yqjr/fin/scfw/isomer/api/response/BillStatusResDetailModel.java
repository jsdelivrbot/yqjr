package com.yqjr.fin.scfw.isomer.api.response;

/**
 * @description: 账单状态查询接口详细返回值
 * @author: lixue
 * @date: 2018/06/14 09:13:50
 **/
public class BillStatusResDetailModel {
    //流水号
    private String serialNo ;

    //账单状态
    private String billStatus;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
