package com.yqjr.fin.mkmm.sales.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

public class ProductCode extends BaseEntity<ProductCode> {

    //region generated by CodeRobot

    private static final long serialVersionUID = 1L;


    /**
     *
     *列表查询页面：/productCode/list
     *表单维护路径：/productCode/form
     *
     */

    /**
     * 序列
     */
    @Digits(fraction =22,integer=0)
    private Long id;

    /**
     * 产品类型
     */
    @Length(min = 0, max = 64)
    private String vdictcode;

    /**
     * 产品类型名称
     */
    @Length(min = 0, max = 64)
    private String vdictname;

    /**
     * 产品编号
     */
    @Digits(fraction =22,integer=0)
    private Long value;

    /**
     * 产品名称
     */
    @Length(min = 0, max = 64)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVdictcode() {
        return vdictcode;
    }

    public void setVdictcode(String vdictcode) {
        this.vdictcode = vdictcode;
    }

    public String getVdictname() {
        return vdictname;
    }

    public void setVdictname(String vdictname) {
        this.vdictname = vdictname;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~此线上方代码自动生成，在此下方编写自定义代码。
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //endregion
}
