package com.yqjr.fin.scfw.isomer.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class IsomerDynamicBill extends BaseEntity<IsomerDynamicBill> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/mkmmYgDynamicBill/list
     *表单维护路径：/mkmmYgDynamicBill/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 请求url
     */
    @Length(min = 0, max = 256)
    private String requestUrl;

    /**
     * 标识 0 正常状态 1 删除
     */
    @Digits(fraction =22,integer=0)
    private Long flag;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 类型
     */
    @Length(min = 0, max = 32)
    private java.lang.String type;

    /**
     * 类型名称
     */
    @Length(min = 0, max = 32)
    private java.lang.String typeName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Long getFlag() {
        return this.flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
