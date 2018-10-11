package com.yqjr.scfw.common.mapper.spring;

import com.yqjr.scfw.common.mapper.mapperhelper.EntityHelper;
import org.apache.ibatis.session.Configuration;

public class MapperFactoryBean<T> extends org.mybatis.spring.mapper.MapperFactoryBean<T> {
    public MapperFactoryBean() {
    }

    public MapperFactoryBean(Class<T> mapperInterface) {
        super(mapperInterface);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void checkDaoConfig() {
        super.checkDaoConfig();

        Class<T> mapperInterface = getObjectType();
        Configuration configuration = getSqlSession().getConfiguration();

        EntityHelper.processConfiguration(this, configuration, mapperInterface);

    }
}
