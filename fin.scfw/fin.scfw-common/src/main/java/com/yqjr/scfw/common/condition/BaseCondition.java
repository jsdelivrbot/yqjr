package com.yqjr.scfw.common.condition;

/**
 * User: Kyll
 * Date: 2018-02-12 14:07
 */
public abstract class BaseCondition<T, PK> {
    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

}
