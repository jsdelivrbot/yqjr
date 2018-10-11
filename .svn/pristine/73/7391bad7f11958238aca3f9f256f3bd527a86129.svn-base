package com.yqjr.fin.scfw.meta.vo;

import com.yqjr.scfw.common.excel.annotation.ExcelVoConfig;
import com.yqjr.scfw.common.excel.annotation.Lang;
import com.yqjr.scfw.common.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class ExcelDemoVO extends BaseExcelVo {
    @Lang(value = "ID")
    private Long id;
    @Lang(value = "菜单名称")
    private String name;
    @Lang(value = "PARENTID")
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public int getHashVal() {
        return 0;
    }
}
