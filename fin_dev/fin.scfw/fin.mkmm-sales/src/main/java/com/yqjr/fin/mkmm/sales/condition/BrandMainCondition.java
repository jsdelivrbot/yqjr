
package com.yqjr.fin.mkmm.sales.condition;

import com.yqjr.fin.mkmm.sales.entity.BrandMain;
import com.yqjr.scfw.common.condition.BaseCondition;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

public class BrandMainCondition extends BaseCondition<BrandMain, Long> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/brandMain/list
     *表单维护路径：/brandMain/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 大品牌id
     */
    @Digits(fraction =22,integer=0)
    private Long ncarbrandid;

    /**
     * 大品牌名称
     */
    @Length(min = 0, max = 200)
    private String ncarbrandname;

    /**
     * 子品牌id
     */
    @Digits(fraction =22,integer=0)
    private Long ncarsubbrandid;

    /**
     * 子品牌名称
     */
    @Length(min = 0, max = 200)
    private String ncarsubbrandname;

    /**
     * 车型id
     */
    @Digits(fraction =22,integer=0)
    private Long ncarbrandtype;

    /**
     * 车型名称
     */
    @Length(min = 0, max = 200)
    private String ncarbrandtypename;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNcarbrandid() {
        return this.ncarbrandid;
    }

    public void setNcarbrandid(Long ncarbrandid) {
        this.ncarbrandid = ncarbrandid;
    }

    public String getNcarbrandname() {
        return this.ncarbrandname;
    }

    public void setNcarbrandname(String ncarbrandname) {
        this.ncarbrandname = ncarbrandname;
    }

    public Long getNcarsubbrandid() {
        return this.ncarsubbrandid;
    }

    public void setNcarsubbrandid(Long ncarsubbrandid) {
        this.ncarsubbrandid = ncarsubbrandid;
    }

    public String getNcarsubbrandname() {
        return this.ncarsubbrandname;
    }

    public void setNcarsubbrandname(String ncarsubbrandname) {
        this.ncarsubbrandname = ncarsubbrandname;
    }

    public Long getNcarbrandtype() {
        return this.ncarbrandtype;
    }

    public void setNcarbrandtype(Long ncarbrandtype) {
        this.ncarbrandtype = ncarbrandtype;
    }

    public String getNcarbrandtypename() {
        return this.ncarbrandtypename;
    }

    public void setNcarbrandtypename(String ncarbrandtypename) {
        this.ncarbrandtypename = ncarbrandtypename;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}