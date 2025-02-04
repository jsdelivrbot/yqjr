
package com.yqjr.fin.mkmm.sales.condition;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.PersonMain;

public class PersonMainCondition extends BaseCondition<PersonMain, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/personMain/list
     *表单维护路径：/personMain/form
     *
     */

    /**
     * 序号
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 员工编号
     */
    @Length(min = 0, max = 12)
    private java.lang.String personCode;

    /**
     * 员工姓名
     */
    @Length(min = 0, max = 16)
    private java.lang.String personName;

    /**
     * 身份证号
     */
    @Length(min = 0, max = 18)
    private java.lang.String personIdcard;

    /**
     * 年龄
     */
    @Length(min = 0, max = 3)
    private java.lang.String personAge;

    /**
     * 民族
     */
    @Length(min = 0, max = 10)
    private java.lang.String personEthnic;

    /**
     * 婚姻状况
     */
    @Length(min = 0, max = 12)
    private java.lang.String personMarr;

    /**
     * 毕业学校
     */
    @Length(min = 0, max = 32)
    private java.lang.String personSchool;

    /**
     * 专业
     */
    @Length(min = 0, max = 32)
    private java.lang.String personSubject;

    /**
     * 最高学历
     */
    @Length(min = 0, max = 32)
    private java.lang.String personEdu;

    /**
     * 学位
     */
    @Length(min = 0, max = 32)
    private java.lang.String personEdulevel;

    /**
     * 工龄
     */
    @Length(min = 0, max = 10)
    private java.lang.String personWorktime;

    /**
     * 参加工作时间
     */
    @JSONField(format="yyyy-MM-dd")
    private java.lang.String personFirstworktime;

    /**
     * 家庭住址
     */
    @Length(min = 0, max = 256)
    private java.lang.String personAddress;

    /**
     * 家庭电话
     */
    @Length(min = 0, max = 12)
    private java.lang.String personHomephone;

    /**
     * 工作电话
     */
    @Length(min = 0, max = 12)
    private java.lang.String personWorkphone;

    /**
     * 移动电话
     */
    @Length(min = 0, max = 11)
    private java.lang.String personPhone;

    /**
     * e-mail
     */
    @Length(min = 0, max = 32)
    private java.lang.String perrsonEmail;

    /**
     * 员工状态(0 无效,1 有效，2 注销)
     */
    @Length(min = 0, max = 6)
    private java.lang.String personStatus;

    /**
     * 生效时间
     */
    @JSONField(format="yyyy-MM-dd")
    private java.util.Date startTime;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 备注
     */
    @Length(min = 0, max = 1000)
    private java.lang.String remark;

    /**
     * 出生日期
     */
    @JSONField(format="yyyy-MM-dd")
    private java.lang.String personBirth;

    /**
     * 备注2
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode2;

    /**
     * 备注3
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode3;

    /**
     * 备注4
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode4;

    /**
     * 创建人
     */
    @Digits(fraction =22,integer=0)
    private Long creator;

    /**
     * 修改人
     */
    @Digits(fraction =22,integer=0)
    private Long modifier;

    /**
     * 最新标识
     */
    @Length(min = 0, max = 256)
    private java.lang.String flag;

    /**
     * 备注1
     */
    @Length(min = 0, max = 256)
    private java.lang.String transcode1;

    /**
     * 登陆名称
     */
    @Length(min = 0, max = 50)
    private java.lang.String loginName;

    /**
     * 所属公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getPersonCode() {
        return this.personCode;
    }

    public void setPersonCode(java.lang.String personCode) {
        this.personCode = personCode;
    }

    public java.lang.String getPersonName() {
        return this.personName;
    }

    public void setPersonName(java.lang.String personName) {
        this.personName = personName;
    }

    public java.lang.String getPersonIdcard() {
        return this.personIdcard;
    }

    public void setPersonIdcard(java.lang.String personIdcard) {
        this.personIdcard = personIdcard;
    }

    public java.lang.String getPersonAge() {
        return this.personAge;
    }

    public void setPersonAge(java.lang.String personAge) {
        this.personAge = personAge;
    }

    public java.lang.String getPersonEthnic() {
        return this.personEthnic;
    }

    public void setPersonEthnic(java.lang.String personEthnic) {
        this.personEthnic = personEthnic;
    }

    public java.lang.String getPersonMarr() {
        return this.personMarr;
    }

    public void setPersonMarr(java.lang.String personMarr) {
        this.personMarr = personMarr;
    }

    public java.lang.String getPersonSchool() {
        return this.personSchool;
    }

    public void setPersonSchool(java.lang.String personSchool) {
        this.personSchool = personSchool;
    }

    public java.lang.String getPersonSubject() {
        return this.personSubject;
    }

    public void setPersonSubject(java.lang.String personSubject) {
        this.personSubject = personSubject;
    }

    public java.lang.String getPersonEdu() {
        return this.personEdu;
    }

    public void setPersonEdu(java.lang.String personEdu) {
        this.personEdu = personEdu;
    }

    public java.lang.String getPersonEdulevel() {
        return this.personEdulevel;
    }

    public void setPersonEdulevel(java.lang.String personEdulevel) {
        this.personEdulevel = personEdulevel;
    }

    public java.lang.String getPersonWorktime() {
        return this.personWorktime;
    }

    public void setPersonWorktime(java.lang.String personWorktime) {
        this.personWorktime = personWorktime;
    }

    public java.lang.String getPersonFirstworktime() {
        return this.personFirstworktime;
    }

    public void setPersonFirstworktime(java.lang.String personFirstworktime) {
        this.personFirstworktime = personFirstworktime;
    }

    public java.lang.String getPersonAddress() {
        return this.personAddress;
    }

    public void setPersonAddress(java.lang.String personAddress) {
        this.personAddress = personAddress;
    }

    public java.lang.String getPersonHomephone() {
        return this.personHomephone;
    }

    public void setPersonHomephone(java.lang.String personHomephone) {
        this.personHomephone = personHomephone;
    }

    public java.lang.String getPersonWorkphone() {
        return this.personWorkphone;
    }

    public void setPersonWorkphone(java.lang.String personWorkphone) {
        this.personWorkphone = personWorkphone;
    }

    public java.lang.String getPersonPhone() {
        return this.personPhone;
    }

    public void setPersonPhone(java.lang.String personPhone) {
        this.personPhone = personPhone;
    }

    public java.lang.String getPerrsonEmail() {
        return this.perrsonEmail;
    }

    public void setPerrsonEmail(java.lang.String perrsonEmail) {
        this.perrsonEmail = perrsonEmail;
    }

    public java.lang.String getPersonStatus() {
        return this.personStatus;
    }

    public void setPersonStatus(java.lang.String personStatus) {
        this.personStatus = personStatus;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getPersonBirth() {
        return this.personBirth;
    }

    public void setPersonBirth(java.lang.String personBirth) {
        this.personBirth = personBirth;
    }

    public java.lang.String getTranscode2() {
        return this.transcode2;
    }

    public void setTranscode2(java.lang.String transcode2) {
        this.transcode2 = transcode2;
    }

    public java.lang.String getTranscode3() {
        return this.transcode3;
    }

    public void setTranscode3(java.lang.String transcode3) {
        this.transcode3 = transcode3;
    }

    public java.lang.String getTranscode4() {
        return this.transcode4;
    }

    public void setTranscode4(java.lang.String transcode4) {
        this.transcode4 = transcode4;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getModifier() {
        return this.modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public java.lang.String getTranscode1() {
        return this.transcode1;
    }

    public void setTranscode1(java.lang.String transcode1) {
        this.transcode1 = transcode1;
    }

    public java.lang.String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}