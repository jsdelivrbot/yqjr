package com.yqjr.fin.scfw.isomer.api.request;


/**
 * @description:事先动支单据主表数据
 * @author: lixue
 * @date: 2018/06/08 14:22:08
 **/

public class FyzlDynamicBillMainModel {

    // 通讯流水号
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

    private String tradecode;

    // 附件张数
    private String attachmentCount;

    //业务编码
    private String businessCode;

    //备注
    private String memo;

    //预留字段
    private String memo1;

    //预留字段
    private String memo2;

    //校验码
    private String validCode;


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

    public String getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(String attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
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

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }


}
