package com.yqjr.fin.mkmm.sales.rest.vo.fee;


import com.yqjr.fin.mkmm.sales.entity.ActiveMatchMain;

public class ActiveMatchMainVo extends ActiveMatchMain {

    //
    private String billStatus;

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}