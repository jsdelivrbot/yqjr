package com.yqjr.scfw.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

//import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long createBy;
//	@Transient
	protected String createByName;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;
	protected Long updateBy;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateDate;
//	@Transient
	protected String updateByName;

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	public Date getCreateDate() {
		if (createDate == null)return null;
		return (Date)createDate.clone();
	}

	public void setCreateDate(Date createDate) {
		if (createDate == null){
			this.createDate = null;
		} else {
			this.createDate =(Date)createDate.clone();
		}
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		if (updateDate == null)return null;
		return (Date)updateDate.clone();
	}

	public void setUpdateDate(Date updateDate) {
		if (updateDate == null){
			this.updateDate = null;
		} else {
			this.updateDate =(Date)updateDate.clone();
		}
	}

	public String getUpdateByName() {
		return updateByName;
	}

	public void setUpdateByName(String updateByName) {
		this.updateByName = updateByName;
	}
}
