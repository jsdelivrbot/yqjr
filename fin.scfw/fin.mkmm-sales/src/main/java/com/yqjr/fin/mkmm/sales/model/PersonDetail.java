package com.yqjr.fin.mkmm.sales.model;

import com.yqjr.fin.mkmm.sales.entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PersonDetail implements Serializable{
    private Long personTeamReviewId;//人员团队审核主表id
    private java.lang.String personCode;//人员代码
    private java.lang.String companyCode;//公司代码
    private java.lang.String teamCode;//团队代码
    private java.lang.String teamName;//团队名称
    private java.lang.String areaCode;//区域代码
    private java.lang.String areaName;//区域名称
    private java.lang.String personNature;//人员性质（0团队负责人，1销售经理）
    private java.lang.String personLevel;//人员级别
    private java.lang.String personStatus;//人员状态
    private java.util.Date personCheckStart;//考核开始时间
    private java.util.Date personUptime;//上岗时间
    private java.util.Date personCorrectime;//转正时间
    private java.util.Date personTryStartime;//试用期开始时间
    private java.util.Date personTryEndtime;//试用期结束时间
    private java.util.Date personJointime;//加入我司时间
    private java.lang.String remark;//备注
    private java.lang.String personName;//人员姓名
    private java.lang.String personIdcard;//身份证号
    private java.lang.String personAge;//年龄
    private java.lang.String personEthnic;//民族
    private java.lang.String personMarr;//婚姻状况
    private java.lang.String personSchool;//毕业学校
    private java.lang.String personSubject;//专业
    private java.lang.String personEdu;//最高学历
    private java.lang.String personEdulevel;//学位
    private java.lang.String personWorktime;//工龄
    private java.util.Date personFirstworktime;//参加工作时间
    private java.lang.String personAddress;//家庭住址
    private java.lang.String personHomephone;//家庭电话
    private java.lang.String personWorkphone;//工作电话
    private java.lang.String personPhone;//移动电话
    private java.lang.String personEmail;//e-mail
    private java.util.Date personBirth;//出生日期

    private java.lang.String reviewStatus;//审核状态（00驳回,01提交审核,02待审核,03审核中,04审核通过）
    private java.lang.String flag;//有效标识（如表记录不删除，以此区分,0无效，1有效）
    private java.lang.String reviewType;//审核类型（01人员新增，02人员修改）
    private java.util.Date startTime;//生效时间
    private java.util.Date createTime;//创建时间
    private java.util.Date modifyTime;//修改时间
    private Long creator;//创建人
    private Long modifier;//修改人
    private String searchPerson;//登录名
    private String company;
    private String [] provinces; //省份数组
    private String [] cities;   //城市数组
    private String [] brands;   //品牌数组

    public String[] getProvinces() {
        return provinces;
    }

    public void setProvinces(String[] provinces) {
        this.provinces = provinces;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String[] getBrands() {
        return brands;
    }

    public void setBrands(String[] brands) {
        this.brands = brands;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getPersonNature() {
        return personNature;
    }

    public void setPersonNature(String personNature) {
        this.personNature = personNature;
    }

    public String getPersonLevel() {
        return personLevel;
    }

    public void setPersonLevel(String personLevel) {
        this.personLevel = personLevel;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public Date getPersonCheckStart() {
        return personCheckStart;
    }

    public void setPersonCheckStart(Date personCheckStart) {
        this.personCheckStart = personCheckStart;
    }

    public Date getPersonUptime() {
        return personUptime;
    }

    public void setPersonUptime(Date personUptime) {
        this.personUptime = personUptime;
    }

    public Date getPersonCorrectime() {
        return personCorrectime;
    }

    public void setPersonCorrectime(Date personCorrectime) {
        this.personCorrectime = personCorrectime;
    }

    public Date getPersonTryStartime() {
        return personTryStartime;
    }

    public void setPersonTryStartime(Date personTryStartime) {
        this.personTryStartime = personTryStartime;
    }

    public Date getPersonTryEndtime() {
        return personTryEndtime;
    }

    public void setPersonTryEndtime(Date personTryEndtime) {
        this.personTryEndtime = personTryEndtime;
    }

    public Date getPersonJointime() {
        return personJointime;
    }

    public void setPersonJointime(Date personJointime) {
        this.personJointime = personJointime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonIdcard() {
        return personIdcard;
    }

    public void setPersonIdcard(String personIdcard) {
        this.personIdcard = personIdcard;
    }

    public String getPersonAge() {
        return personAge;
    }

    public void setPersonAge(String personAge) {
        this.personAge = personAge;
    }

    public String getPersonEthnic() {
        return personEthnic;
    }

    public void setPersonEthnic(String personEthnic) {
        this.personEthnic = personEthnic;
    }

    public String getPersonMarr() {
        return personMarr;
    }

    public void setPersonMarr(String personMarr) {
        this.personMarr = personMarr;
    }

    public String getPersonSchool() {
        return personSchool;
    }

    public void setPersonSchool(String personSchool) {
        this.personSchool = personSchool;
    }

    public String getPersonSubject() {
        return personSubject;
    }

    public void setPersonSubject(String personSubject) {
        this.personSubject = personSubject;
    }

    public String getPersonEdu() {
        return personEdu;
    }

    public void setPersonEdu(String personEdu) {
        this.personEdu = personEdu;
    }

    public String getPersonEdulevel() {
        return personEdulevel;
    }

    public void setPersonEdulevel(String personEdulevel) {
        this.personEdulevel = personEdulevel;
    }

    public String getPersonWorktime() {
        return personWorktime;
    }

    public void setPersonWorktime(String personWorktime) {
        this.personWorktime = personWorktime;
    }

    public Date getPersonFirstworktime() {
        return personFirstworktime;
    }

    public void setPersonFirstworktime(Date personFirstworktime) {
        this.personFirstworktime = personFirstworktime;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonHomephone() {
        return personHomephone;
    }

    public void setPersonHomephone(String personHomephone) {
        this.personHomephone = personHomephone;
    }

    public String getPersonWorkphone() {
        return personWorkphone;
    }

    public void setPersonWorkphone(String personWorkphone) {
        this.personWorkphone = personWorkphone;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Date getPersonBirth() { return personBirth; }

    public void setPersonBirth(Date personBirth) {
        this.personBirth = personBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
    public String getSearchPerson() {
        return searchPerson;
    }

    public void setSearchPerson(String searchPerson) {
        this.searchPerson = searchPerson;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getPersonTeamReviewId() {
        return personTeamReviewId;
    }

    public void setPersonTeamReviewId(Long personTeamReviewId) {
        this.personTeamReviewId = personTeamReviewId;
    }
}
