package com.yqjr.fin.scfw.meta.entity;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import javax.validation.constraints.Digits;

public class User extends BaseEntity<User> {


    private static final long serialVersionUID = 1L;

   /**
    * 主键
    */
   @Digits(fraction =22,integer=0)
   private Long id;

   /**
    * 登陆名，英文，唯一
    */
   @Length(min = 0, max = 200)
   private String loginName;

   /**
    * 密码，md5加密后密文
    */
   @Length(min = 0, max = 50)
   private String loginPassword;

   /**
    * 用户名称，中文
    */
   @Length(min = 0, max = 200)
   private String userName;

   /**
    * OA员工编号
    */
   @Length(min = 0, max = 50)
   private String oaFdno;

   /**
    * 合同所属公司:见数据字典:comCode
    */
   private String comCode;

   /**
    * 所属机构
    */
   @Length(min = 0, max = 30)
   private String organizationNo;

   /**
    * 首次登记日期
    */
   private Date registDate;

   /**
    * 首次等级人登陆名
    */
   @Length(min = 0, max = 50)
   private String registUser;

   /**
    * 性别:见数据字典:sex
    */
   private String sex;

   /**
    * 手机
    */
   @Length(min = 0, max = 30)
   private String mobile;

   /**
    * 邮箱
    */
   @Length(min = 0, max = 50)
   private String email;

   /**
    * 微信OPEN_ID
    */
   @Length(min = 0, max = 50)
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
    * 创建人
    */
   @Digits(fraction =22,integer=0)
   private Long creator;

   /**
    * 创建时间
    */
   private Date createTime;

   /**
    * 最后更新人
    */
   @Digits(fraction =22,integer=0)
   private Long modifier;

   /**
    * 最后更新时间
    */
   private Date modifyTime;

   /**
    * 合同所属公司名字
    */
   @Length(min = 0, max = 30)
   private String comName;

   /**
    * 身份证号
    */
   @Length(min = 0, max = 20)
   private String idcard;

   /**
    * 出生日期
    */
   private Date birthday;

   /**
    * 民族
    */
   @Length(min = 0, max = 10)
   private String personethnic;

   /**
    * 婚姻状况
    */
   @Length(min = 0, max = 10)
   private String personmarr;

   /**
    * 毕业学校
    */
   @Length(min = 0, max = 20)
   private String personschool;

   /**
    * 专业
    */
   @Length(min = 0, max = 20)
   private String personsubject;

   /**
    * 最高学历
    */
   @Length(min = 0, max = 20)
   private String personedu;

   /**
    * 学位
    */
   @Length(min = 0, max = 20)
   private String personedulevel;

   /**
    * 参加工作时间
    */
   private Date personjointime;

   /**
    * 人员性质
    */
   @Length(min = 0, max = 20)
   private String personnature;

   /**
    * 人员级别
    */
   @Length(min = 0, max = 20)
   private String personlevel;
   
   @Length(min = 0, max = 20)
   private String areaCode;
   
   @Length(min = 0, max = 20)
   private String areaName;

   public Long getId() {
       return this.id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getLoginName() {
       return this.loginName;
   }

   public void setLoginName(String loginName) {
       this.loginName = loginName;
   }

   public String getLoginPassword() {
       return this.loginPassword;
   }

   public void setLoginPassword(String loginPassword) {
       this.loginPassword = loginPassword;
   }

   public String getUserName() {
       return this.userName;
   }

   public void setUserName(String userName) {
       this.userName = userName;
   }

   public String getOaFdno() {
       return this.oaFdno;
   }

   public void setOaFdno(String oaFdno) {
       this.oaFdno = oaFdno;
   }

   public String getComcode() {
       return this.comCode;
   }

   public void setComcode(String comCode) {
       this.comCode = comCode;
   }

   public String getOrganizationNo() {
       return this.organizationNo;
   }

   public void setOrganizationNo(String organizationNo) {
       this.organizationNo = organizationNo;
   }

   public Date getRegistDate() {
       return this.registDate;
   }

   public void setRegistDate(Date registDate) {
       this.registDate = registDate;
   }

   public String getRegistUser() {
       return this.registUser;
   }

   public void setRegistUser(String registUser) {
       this.registUser = registUser;
   }

   public String getSex() {
       return this.sex;
   }

   public void setSex(String sex) {
       this.sex = sex;
   }

   public String getMobile() {
       return this.mobile;
   }

   public void setMobile(String mobile) {
       this.mobile = mobile;
   }

   public String getEmail() {
       return this.email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getWcOpenid() {
       return this.wcOpenid;
   }

   public void setWcOpenid(String wcOpenid) {
       this.wcOpenid = wcOpenid;
   }

   public String getStatus() {
       return this.status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

   public Date getPassInvalidDate() {
       return this.passInvalidDate;
   }

   public void setPassInvalidDate(Date passInvalidDate) {
       this.passInvalidDate = passInvalidDate;
   }

   public String getDataAuthType() {
       return this.dataAuthType;
   }

   public void setDataAuthType(String dataAuthType) {
       this.dataAuthType = dataAuthType;
   }

   public Long getCreator() {
       return this.creator;
   }

   public void setCreator(Long creator) {
       this.creator = creator;
   }

   public Date getCreateTime() {
       return this.createTime;
   }

   public void setCreateTime(Date createTime) {
       this.createTime = createTime;
   }

   public Long getModifier() {
       return this.modifier;
   }

   public void setModifier(Long modifier) {
       this.modifier = modifier;
   }

   public Date getModifyTime() {
       return this.modifyTime;
   }

   public void setModifyTime(Date modifyTime) {
       this.modifyTime = modifyTime;
   }

   public String getComname() {
       return this.comName;
   }

   public void setComname(String comName) {
       this.comName = comName;
   }

   public String getIdcard() {
       return this.idcard;
   }

   public void setIdcard(String idcard) {
       this.idcard = idcard;
   }

   public Date getBirthday() {
       return this.birthday;
   }

   public void setBirthday(Date birthday) {
       this.birthday = birthday;
   }

   public String getPersonethnic() {
       return this.personethnic;
   }

   public void setPersonethnic(String personethnic) {
       this.personethnic = personethnic;
   }

   public String getPersonmarr() {
       return this.personmarr;
   }

   public void setPersonmarr(String personmarr) {
       this.personmarr = personmarr;
   }

   public String getPersonschool() {
       return this.personschool;
   }

   public void setPersonschool(String personschool) {
       this.personschool = personschool;
   }

   public String getPersonsubject() {
       return this.personsubject;
   }

   public void setPersonsubject(String personsubject) {
       this.personsubject = personsubject;
   }

   public String getPersonedu() {
       return this.personedu;
   }

   public void setPersonedu(String personedu) {
       this.personedu = personedu;
   }

   public String getPersonedulevel() {
       return this.personedulevel;
   }

   public void setPersonedulevel(String personedulevel) {
       this.personedulevel = personedulevel;
   }

   public Date getPersonjointime() {
       return this.personjointime;
   }

   public void setPersonjointime(Date personjointime) {
       this.personjointime = personjointime;
   }

   public String getPersonnature() {
       return this.personnature;
   }

   public void setPersonnature(String personnature) {
       this.personnature = personnature;
   }

   public String getPersonlevel() {
       return this.personlevel;
   }

   public void setPersonlevel(String personlevel) {
       this.personlevel = personlevel;
   }

public String getComCode() {
	return comCode;
}

public void setComCode(String comCode) {
	this.comCode = comCode;
}

public String getComName() {
	return comName;
}

public void setComName(String comName) {
	this.comName = comName;
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
