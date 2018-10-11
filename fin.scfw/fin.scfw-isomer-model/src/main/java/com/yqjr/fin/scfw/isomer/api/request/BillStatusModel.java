package com.yqjr.fin.scfw.isomer.api.request;

/**
 * @description: 订单状态查询
 * @author: lixue
 * @date: 2018/06/08 16:04:54
 **/
public class BillStatusModel {

    private String billNumber;
    private String createTime;
    private String executeStatus;
    private String executeTime;
    private String externalReferenceNo;
    private String failcause;
    private String fromSystem;
    private String memo1;
    private String memo2;
    private String message;
    private String msgRef;
    private String state;
    private String toSystem;

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getExternalReferenceNo() {
        return externalReferenceNo;
    }

    public void setExternalReferenceNo(String externalReferenceNo) {
        this.externalReferenceNo = externalReferenceNo;
    }

    public String getFailcause() {
        return failcause;
    }

    public void setFailcause(String failcause) {
        this.failcause = failcause;
    }

    public String getFromSystem() {
        return fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgRef() {
        return msgRef;
    }

    public void setMsgRef(String msgRef) {
        this.msgRef = msgRef;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getToSystem() {
        return toSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem;
    }
}
