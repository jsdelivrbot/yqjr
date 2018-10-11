package com.yqjr.fin.fcsw.meta.api.dto;

import java.util.Date;

public class UserDto {
	  /**
	    * 主键
	    */
	   
	   private Long id;

	   /**
	    * 登陆名，英文，唯一
	    */
	   private String loginName;


	   /**
	    * 用户名称，中文
	    */
	   
	   private String userName;

	   /**
	    * OA员工编号
	    */
	   
	   private String oaFdno;

	   /**
	    * 合同所属公司:见数据字典:comCode
	    */
	   private String comCode;

	   /**
	    * 所属机构
	    */
	   
	   private String organizationNo;

	   /**
	    * 首次登记日期
	    */
	   private String registDate;

	   /**
	    * 首次等级人登陆名
	    */
	   
	   private String registUser;

	   /**
	    * 性别:见数据字典:sex
	    */
	   private String sex;

	   /**
	    * 手机
	    */
	   
	   private String mobile;

	   /**
	    * 邮箱
	    */
	   
	   private String email;

	   /**
	    * 微信OPEN_ID
	    */
	   
	   private String wcOpenid;

	   /**
	    * ‘0’ 无效 '1' 有效
	    */
	   private String status;

	   /**
	    * 口令失效日期
	    */
	   private Date passInvalidDate;

	   /**
	    * 数据授权类型 ‘1’ 按地区,'2' 按经销商,'0',可看全部数据
	    */
	   private String dataAuthType;


	   /**
	    * 合同所属公司名字
	    */
	   
	   private String comName;

	   /**
	    * 身份证号
	    */
	   
	   private String idcard;

	   /**
	    * 出生日期
	    */
	   private Date birthday;

	   /**
	    * 民族
	    */
	   
	   private String personethnic;

	   /**
	    * 婚姻状况
	    */
	   
	   private String personmarr;

	   /**
	    * 毕业学校
	    */
	   
	   private String personschool;

	   /**
	    * 专业
	    */
	   
	   private String personsubject;

	   /**
	    * 最高学历
	    */
	   
	   private String personedu;

	   /**
	    * 学位
	    */
	   
	   private String personedulevel;

	   /**
	    * 参加工作时间
	    */
	   private Date personjointime;

	   /**
	    * 人员性质
	    */
	   
	   private String personnature;

	   /**
	    * 人员级别
	    */
	   
	   private String personlevel;
	   private String areaCode;
	   private String areaName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOaFdno() {
		return oaFdno;
	}
	public void setOaFdno(String oaFdno) {
		this.oaFdno = oaFdno;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getOrganizationNo() {
		return organizationNo;
	}
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getRegistUser() {
		return registUser;
	}
	public void setRegistUser(String registUser) {
		this.registUser = registUser;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWcOpenid() {
		return wcOpenid;
	}
	public void setWcOpenid(String wcOpenid) {
		this.wcOpenid = wcOpenid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPassInvalidDate() {
		return passInvalidDate;
	}
	public void setPassInvalidDate(Date passInvalidDate) {
		this.passInvalidDate = passInvalidDate;
	}
	public String getDataAuthType() {
		return dataAuthType;
	}
	public void setDataAuthType(String dataAuthType) {
		this.dataAuthType = dataAuthType;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPersonethnic() {
		return personethnic;
	}
	public void setPersonethnic(String personethnic) {
		this.personethnic = personethnic;
	}
	public String getPersonmarr() {
		return personmarr;
	}
	public void setPersonmarr(String personmarr) {
		this.personmarr = personmarr;
	}
	public String getPersonschool() {
		return personschool;
	}
	public void setPersonschool(String personschool) {
		this.personschool = personschool;
	}
	public String getPersonsubject() {
		return personsubject;
	}
	public void setPersonsubject(String personsubject) {
		this.personsubject = personsubject;
	}
	public String getPersonedu() {
		return personedu;
	}
	public void setPersonedu(String personedu) {
		this.personedu = personedu;
	}
	public String getPersonedulevel() {
		return personedulevel;
	}
	public void setPersonedulevel(String personedulevel) {
		this.personedulevel = personedulevel;
	}
	public Date getPersonjointime() {
		return personjointime;
	}
	public void setPersonjointime(Date personjointime) {
		this.personjointime = personjointime;
	}
	public String getPersonnature() {
		return personnature;
	}
	public void setPersonnature(String personnature) {
		this.personnature = personnature;
	}
	public String getPersonlevel() {
		return personlevel;
	}
	public void setPersonlevel(String personlevel) {
		this.personlevel = personlevel;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	   
}
