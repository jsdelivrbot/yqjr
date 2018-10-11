package com.yqjr.scfw.common.session;

import java.util.Date;
import java.util.List;

/**
 * User: Kyll Date: 2017-12-07 14:24
 */
public class UserContext {
	private String id;
	private String loginName;// 登陆名，英文，唯一
	private String name;//用户名称，中文
	private String oaFdno;//OA员工编号
	private String comCode;//公司代码
	private String organizationNo;//所属机构
	private Date registDate;//首次登记日期
	private String registUser;//首次等级人登陆名
	private String sex;//性别
	private String mobile;// 手机
	private String email;//邮箱
	private String wcOpenid;// 微信OPEN_ID
	private String status;//‘0’ 无效 '1' 有效
	private Date passInvalidDate;//口令失效日期
	private String dataAuthType;//数据授权类型 ‘1’ 按地区,'2' 按经销商,'0',可看全部数据
	private String comName;//合同所属公司名字
	private String idcard;//身份证号
	private Date birthday;//出生日期
	private String personethnic;//民族
	private String personmarr;//婚姻状况
	private String personschool;//毕业学校
	private String personsubject;//专业
	private String personedu;//最高学历
	private String personedulevel;//学位
	private Date personjointime;// 参加工作时间
	private String personnature;//人员性质
	private String personlevel;//人员级别
	private String areaCode;//区域代码
	private String areaName;//区域名称
	private String roleIdList;
	private String roleCodeList;
	private List<Integer> roleSystemIdList;
	private List<String> roleSystemNameList;
	private String jwtToken;
	private Date jwtExpiration;
	private UserContext() {
	}

	public static UserContext create() {
		return new UserContext();
	}

	public String getId() {
		return id;
	}

	public UserContext setId(String id) {
		this.id = id;
		return this;
	}

	public String getLoginName() {
		return loginName;
	}

	public UserContext setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserContext setName(String name) {
		this.name = name;
		return this;
	}

	public String getRoleIdList() {
		return roleIdList;
	}

	public UserContext setRoleIdList(String roleIdList) {
		this.roleIdList = roleIdList;
		return this;
	}

	public List<Integer> getRoleSystemIdList() {
		return roleSystemIdList;
	}

	public UserContext setRoleSystemIdList(List<Integer> roleSystemIdList) {
		this.roleSystemIdList = roleSystemIdList;
		return this;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public UserContext setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
		return this;
	}

	public Date getJwtExpiration() {
		return jwtExpiration == null ? null : (Date) jwtExpiration.clone();
	}

	public UserContext setJwtExpiration(Date jwtExpiration) {
		if (jwtExpiration == null) {
			this.jwtExpiration = null;
		} else {
			this.jwtExpiration = (Date) jwtExpiration.clone();
		}
		return this;
	}

	public List<String> getRoleSystemNameList() {
		return roleSystemNameList;
	}

	public UserContext setRoleSystemNameList(List<String> roleSystemNameList) {
		this.roleSystemNameList = roleSystemNameList;
		return this;
	}

	public String getOaFdno() {
		return oaFdno;
	}

	public UserContext setOaFdno(String oaFdno) {
		this.oaFdno = oaFdno;
		return this;
	}

	public String getComCode() {
		return comCode;
	}

	public UserContext setComCode(String comCode) {
		this.comCode = comCode;
		return this;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public UserContext setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
		return this;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public UserContext setRegistDate(Date registDate) {
		this.registDate = registDate;
		return this;
	}

	public String getRegistUser() {
		return registUser;
	}

	public UserContext setRegistUser(String registUser) {
		this.registUser = registUser;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public UserContext setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UserContext setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserContext setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getWcOpenid() {
		return wcOpenid;
	}

	public UserContext setWcOpenid(String wcOpenid) {
		this.wcOpenid = wcOpenid;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public UserContext setStatus(String status) {
		this.status = status;
		return this;
	}

	public Date getPassInvalidDate() {
		return passInvalidDate;
	}

	public UserContext setPassInvalidDate(Date passInvalidDate) {
		this.passInvalidDate = passInvalidDate;
		return this;
	}

	public String getDataAuthType() {
		return dataAuthType;
	}

	public UserContext setDataAuthType(String dataAuthType) {
		this.dataAuthType = dataAuthType;
		return this;
	}

	public String getComName() {
		return comName;
	}

	public UserContext setComName(String comName) {
		this.comName = comName;
		return this;
	}

	public String getIdcard() {
		return idcard;
	}

	public UserContext setIdcard(String idcard) {
		this.idcard = idcard;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public UserContext setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	public String getPersonethnic() {
		return personethnic;
	}

	public UserContext setPersonethnic(String personethnic) {
		this.personethnic = personethnic;
		return this;
	}

	public String getPersonmarr() {
		return personmarr;
	}

	public UserContext setPersonmarr(String personmarr) {
		this.personmarr = personmarr;
		return this;
	}

	public String getPersonschool() {
		return personschool;
	}

	public UserContext setPersonschool(String personschool) {
		this.personschool = personschool;
		
		return this;
	}

	public String getPersonsubject() {
		return personsubject;
	}

	public UserContext setPersonsubject(String personsubject) {
		this.personsubject = personsubject;
		return this;
	}

	public String getPersonedu() {
		return personedu;
	}

	public UserContext setPersonedu(String personedu) {
		this.personedu = personedu;
		return this;
	}

	public String getPersonedulevel() {
		return personedulevel;
	}

	public UserContext setPersonedulevel(String personedulevel) {
		this.personedulevel = personedulevel;
		return this;
	}

	public Date getPersonjointime() {
		return personjointime;
	}

	public UserContext setPersonjointime(Date personjointime) {
		this.personjointime = personjointime;
		return this;
	}

	public String getPersonnature() {
		return personnature;
	}

	public UserContext setPersonnature(String personnature) {
		this.personnature = personnature;
		return this;
	}

	public String getPersonlevel() {
		return personlevel;
	}

	public UserContext setPersonlevel(String personlevel) {
		this.personlevel = personlevel;
		return this;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public UserContext setAreaCode(String areaCode) {
		this.areaCode = areaCode;
		return this;
	}

	public String getAreaName() {
		return areaName;
	}

	public UserContext setAreaName(String areaName) {
		this.areaName = areaName;
		return this;
	}

	public String getRoleCodeList() {
		return roleCodeList;
	}

	public UserContext setRoleCodeList(String roleCodeList) {
		this.roleCodeList = roleCodeList;
		return this;
	}
	
	

}
