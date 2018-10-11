package com.yqjr.fin.common.base.starter.dto;

import java.io.Serializable;
import java.util.Date;

/**
* 公共dto类
* @Author:         zxd
* @CreateDate:     2018/8/27 8:47
*/
public abstract class FinBaseDto implements Serializable {

    protected Long createBy;

    protected Date createTime;

    protected Long updateBy;

    protected Date updateTime;

    protected String createName;

    protected String updateName;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
}
