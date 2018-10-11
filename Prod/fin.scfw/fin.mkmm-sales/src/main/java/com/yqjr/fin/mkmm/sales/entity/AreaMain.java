package com.yqjr.fin.mkmm.sales.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class AreaMain extends BaseEntity<AreaMain> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/areaMain/list
     *表单维护路径：/areaMain/form
     *
     */

    /**
     * ID
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * index
     */
    @Digits(fraction =22,integer=0)
    private Long nparentid;

    /**
     * 区域名称
     */
    @Length(min = 0, max = 200)
    private java.lang.String vname;

    /**
     * 组织机构编号
     */
    @Length(min = 0, max = 200)
    private java.lang.String vorganizationno;

    /**
     * 直客合同号生成简写 如CC ,SZ,BJ等
     */
    @Length(min = 0, max = 20)
    private java.lang.String vsimplename;

    /**
     * 是否为二级区域
     */
    @Digits(fraction =22,integer=0)
    private Long nischildarea;

    /**
     * 是否为大区
     */
    @Digits(fraction =22,integer=0)
    private Long nisparentarea;

    /**
     * 业务类型,1乘用车零售贷款2乘用车零售租赁
     */
    @Digits(fraction =22,integer=0)
    private Long nptype;

    /**
     * 公司
     */
    @Length(min = 0, max = 20)
    private java.lang.String company;

    public java.lang.String getCompany() {
        return this.company;
    }

    public void setCompany(java.lang.String company) {
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNparentid() {
        return this.nparentid;
    }

    public void setNparentid(Long nparentid) {
        this.nparentid = nparentid;
    }

    public java.lang.String getVname() {
        return this.vname;
    }

    public void setVname(java.lang.String vname) {
        this.vname = vname;
    }

    public java.lang.String getVorganizationno() {
        return this.vorganizationno;
    }

    public void setVorganizationno(java.lang.String vorganizationno) {
        this.vorganizationno = vorganizationno;
    }

    public java.lang.String getVsimplename() {
        return this.vsimplename;
    }

    public void setVsimplename(java.lang.String vsimplename) {
        this.vsimplename = vsimplename;
    }

    public Long getNischildarea() {
        return this.nischildarea;
    }

    public void setNischildarea(Long nischildarea) {
        this.nischildarea = nischildarea;
    }

    public Long getNisparentarea() {
        return this.nisparentarea;
    }

    public void setNisparentarea(Long nisparentarea) {
        this.nisparentarea = nisparentarea;
    }

    public Long getNptype() {
        return this.nptype;
    }

    public void setNptype(Long nptype) {
        this.nptype = nptype;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
