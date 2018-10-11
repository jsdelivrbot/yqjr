package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.UserRelation;

public class UserRelationCondition extends BaseCondition<UserRelation, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/userRelation/list
     *表单维护路径：/userRelation/form
     *
     */

    /**
     * 主键id
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 人员名称
     */
    @Length(min = 0, max = 50)
    private String userName;

    /**
     * 共享系统人员编码
     */
    @Length(min = 0, max = 50)
    private String psUserCode;

    /**
     * 共享系统人部门编码
     */
    @Length(min = 0, max = 50)
    private String psDepartmentCode;

    /**
     * 共享系统人部门名称
     */
    @Length(min = 0, max = 50)
    private String psDepartmentName;

    /**
     * 平台人员id
     */
    @Digits(fraction =22,integer=0)
    private Long plarformUserId;

    /**
     * 平台人员名称
     */
    @Length(min = 0, max = 50)
    private String plarformUserName;

    /**
     * 所属公司类型 0 汽车金融 1 租赁公司
     */
    @Length(min = 0, max = 10)
    private String company;

    /**
     * 所属公司名称
     */
    @Length(min = 0, max = 50)
    private String companyName;

    /**
     * 备注
     */
    @Length(min = 0, max = 256)
    private String remark;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    private java.util.Date updateTime;

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
     * 有效标识（如表记录不删除，以此区分,0无效，1有效）
     */
    @Length(min = 0, max = 10)
    private String flag;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPsUserCode() {
        return this.psUserCode;
    }

    public void setPsUserCode(String psUserCode) {
        this.psUserCode = psUserCode;
    }

    public String getPsDepartmentCode() {
        return this.psDepartmentCode;
    }

    public void setPsDepartmentCode(String psDepartmentCode) {
        this.psDepartmentCode = psDepartmentCode;
    }

    public String getPsDepartmentName() {
        return this.psDepartmentName;
    }

    public void setPsDepartmentName(String psDepartmentName) {
        this.psDepartmentName = psDepartmentName;
    }

    public Long getPlarformUserId() {
        return this.plarformUserId;
    }

    public void setPlarformUserId(Long plarformUserId) {
        this.plarformUserId = plarformUserId;
    }

    public String getPlarformUserName() {
        return this.plarformUserName;
    }

    public void setPlarformUserName(String plarformUserName) {
        this.plarformUserName = plarformUserName;
    }

    public String getCompany() { return this.company; }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
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

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}