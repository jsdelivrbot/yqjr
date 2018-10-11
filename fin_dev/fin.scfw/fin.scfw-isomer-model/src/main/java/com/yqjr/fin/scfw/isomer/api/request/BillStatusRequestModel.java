package com.yqjr.fin.scfw.isomer.api.request;

/**
 * @description: 账单状态查询公共数据
 * @author: lixue
 * @date: 2018/06/13 11:47:10
 **/
public class BillStatusRequestModel {

    //通讯流水号
    private String externalReferenceNo;

    //来源系统
    private String fromSystem;

    //主流水号
    private String msgRef;

    //创建人
    private String requisitionUser;

    //创建人公司
    private String requisitionUserCompany;

    //创建人部门
    private String requisitionUserDepartment;

    //目标系统
    private String toSystem;

    //
    private String tradecode;

    public String getExternalReferenceNo() {
        return externalReferenceNo;
    }

    public void setExternalReferenceNo(String externalReferenceNo) {
        this.externalReferenceNo = externalReferenceNo;
    }

    public String getFromSystem() {
        return fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public String getMsgRef() {
        return msgRef;
    }

    public void setMsgRef(String msgRef) {
        this.msgRef = msgRef;
    }

    public String getRequisitionUser() {
        return requisitionUser;
    }

    public void setRequisitionUser(String requisitionUser) {
        this.requisitionUser = requisitionUser;
    }

    public String getRequisitionUserCompany() {
        return requisitionUserCompany;
    }

    public void setRequisitionUserCompany(String requisitionUserCompany) {
        this.requisitionUserCompany = requisitionUserCompany;
    }

    public String getRequisitionUserDepartment() {
        return requisitionUserDepartment;
    }

    public void setRequisitionUserDepartment(String requisitionUserDepartment) {
        this.requisitionUserDepartment = requisitionUserDepartment;
    }

    public String getToSystem() {
        return toSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem;
    }

    public String getTradecode() {
        return tradecode;
    }

    public void setTradecode(String tradecode) {
        this.tradecode = tradecode;
    }
}
