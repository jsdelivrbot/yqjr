package com.yqjr.fin.scfw.isomer.api.request;

import java.util.List;

/**
 * @description: 事先动支单据基础数据
 * @author: lixue
 * @date: 2018/06/08 14:51:53
 **/
public class DynamicBillRequestModel {

    // 汽车金融事先动支单据主数据
    private FyafDynamicBillMainModel fyafDynamicBillMain;

    // 汽车金融事先动支单据详细数据
    private List<FyafDynamicBillDetailModel> fyafdetailList;

    // 租赁公司事先动支单据主数据
    private FyzlDynamicBillMainModel fyzlDynamicBillMain;

    // 租赁公司事先动支单据详细数据
    private List<FyzlDynamicBillDetailModel> fyzldetailList;

    //账单状态查询
    private BillStatusRequestModel billStatusReuqest;

    //账单状态查询
    private List<BillStatusModel> billStatusList;

    public FyafDynamicBillMainModel getFyafDynamicBillMain() {
        return fyafDynamicBillMain;
    }

    public void setFyafDynamicBillMain(FyafDynamicBillMainModel fyafDynamicBillMain) {
        this.fyafDynamicBillMain = fyafDynamicBillMain;
    }

    public List<FyafDynamicBillDetailModel> getFyafdetailList() {
        return fyafdetailList;
    }

    public void setFyafdetailList(List<FyafDynamicBillDetailModel> fyafdetailList) {
        this.fyafdetailList = fyafdetailList;
    }

    public FyzlDynamicBillMainModel getFyzlDynamicBillMain() {
        return fyzlDynamicBillMain;
    }

    public void setFyzlDynamicBillMain(FyzlDynamicBillMainModel fyzlDynamicBillMain) {
        this.fyzlDynamicBillMain = fyzlDynamicBillMain;
    }

    public List<FyzlDynamicBillDetailModel> getFyzldetailList() {
        return fyzldetailList;
    }

    public void setFyzldetailList(List<FyzlDynamicBillDetailModel> fyzldetailList) {
        this.fyzldetailList = fyzldetailList;
    }

    public BillStatusRequestModel getBillStatusReuqest() {
        return billStatusReuqest;
    }

    public void setBillStatusReuqest(BillStatusRequestModel billStatusReuqest) {
        this.billStatusReuqest = billStatusReuqest;
    }

    public List<BillStatusModel> getBillStatusList() {
        return billStatusList;
    }

    public void setBillStatusList(List<BillStatusModel> billStatusList) {
        this.billStatusList = billStatusList;
    }
}
