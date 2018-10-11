
package com.yqjr.fin.mkmm.sales.condition;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

import com.yqjr.scfw.common.condition.BaseCondition;

import com.yqjr.fin.mkmm.sales.entity.TeamHis;

public class TeamHisCondition extends BaseCondition<TeamHis, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/teamHis/list
     *表单维护路径：/teamHis/form
     *
     */

    /**
     * 序号
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 归属区域代码
     */
    @Length(min = 0, max = 30)
    private String areaCode;

    /**
     * 归属区域名称
     */
    @Length(min = 0, max = 128)
    private String areaName;

    /**
     * 团队代码
     */
    @Length(min = 0, max = 30)
    private String teamCode;

    /**
     * 团队名称
     */
    @Length(min = 0, max = 128)
    private String teamName;

    /**
     * 团队级别（01一级，02二级，03三级）
     */
    @Length(min = 0, max = 64)
    private String teamLevel;

    /**
     * 团队类型（01普通）
     */
    @Length(min = 0, max = 30)
    private String teamType;

    /**
     * 有效状态(0 无效,1 有效)
     */
    @Length(min = 0, max = 30)
    private String teamStatus;

    /**
     * 团队负责人
     */
    @Length(min = 0, max = 30)
    private String teamLeader;

    /**
     * 电话
     */
    @Length(min = 0, max = 30)
    private String teamPhone;

    /**
     * 邮编
     */
    @Length(min = 0, max = 30)
    private String teamZip;

    /**
     * 地址
     */
    @Length(min = 0, max = 128)
    private String teamAddress;

    /**
     * 传真
     */
    @Length(min = 0, max = 30)
    private String teamFax;

    /**
     * 生效时间
     */
    private java.util.Date startTime;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modtfyTime;

    /**
     * 操作员
     */
    @Length(min = 0, max = 30)
    private String operatePerson;

    /**
     * 操作状态(生效，新增未提交，修改未提交，审核中，审核退回,可能没啥用)
     */
    @Length(min = 0, max = 30)
    private String operateStatus;

    /**
     * 是否最新标识
     */
    @Length(min = 0, max = 30)
    private String flag;

    /**
     * 备注
     */
    @Length(min = 0, max = 530)
    private String remark;

    /**
     * 备注1
     */
    @Length(min = 0, max = 256)
    private String transcode1;

    /**
     * 备注2
     */
    @Length(min = 0, max = 256)
    private String transcode2;

    /**
     * 备注3
     */
    @Length(min = 0, max = 256)
    private String transcode3;

    /**
     * 备注4
     */
    @Length(min = 0, max = 256)
    private String transcode4;

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
     * 审核ID
     * @return
     */
    @Digits(fraction =22,integer=0)
    private Long reviewId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTeamCode() {
        return this.teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLevel() {
        return this.teamLevel;
    }

    public void setTeamLevel(String teamLevel) {
        this.teamLevel = teamLevel;
    }

    public String getTeamType() {
        return this.teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getTeamStatus() {
        return this.teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getTeamLeader() {
        return this.teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTeamPhone() {
        return this.teamPhone;
    }

    public void setTeamPhone(String teamPhone) {
        this.teamPhone = teamPhone;
    }

    public String getTeamZip() {
        return this.teamZip;
    }

    public void setTeamZip(String teamZip) {
        this.teamZip = teamZip;
    }

    public String getTeamAddress() {
        return this.teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }

    public String getTeamFax() {
        return this.teamFax;
    }

    public void setTeamFax(String teamFax) {
        this.teamFax = teamFax;
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

    public java.util.Date getModtfyTime() {
        return this.modtfyTime;
    }

    public void setModtfyTime(java.util.Date modtfyTime) {
        this.modtfyTime = modtfyTime;
    }

    public String getOperatePerson() {
        return this.operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson;
    }

    public String getOperateStatus() {
        return this.operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTranscode1() {
        return this.transcode1;
    }

    public void setTranscode1(String transcode1) {
        this.transcode1 = transcode1;
    }

    public String getTranscode2() {
        return this.transcode2;
    }

    public void setTranscode2(String transcode2) {
        this.transcode2 = transcode2;
    }

    public String getTranscode3() {
        return this.transcode3;
    }

    public void setTranscode3(String transcode3) {
        this.transcode3 = transcode3;
    }

    public String getTranscode4() {
        return this.transcode4;
    }

    public void setTranscode4(String transcode4) {
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

    public Long getReviewId() { return reviewId; }

    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}