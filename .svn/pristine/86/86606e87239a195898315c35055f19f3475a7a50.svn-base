package com.yqjr.fin.common.base.starter.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

public abstract class FinBaseMapperEntity<PK> extends BaseMapperEntity<PK> {
    @ColumnType(
            jdbcType = JdbcType.VARCHAR
    )
    protected String createName;

    @ColumnType(
            jdbcType = JdbcType.VARCHAR
    )
    protected String updateName;

    public FinBaseMapperEntity() {
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
}
