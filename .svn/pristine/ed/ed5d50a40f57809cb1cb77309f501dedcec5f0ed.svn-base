package com.yqjr.scfw.common.pagination.interceptor;

import com.yqjr.scfw.common.pagination.dialect.Dialect;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.pagination.model.PageList;
import com.yqjr.scfw.common.pagination.support.PropertiesHelper;
import com.yqjr.scfw.common.pagination.support.SQLHelper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author quangz
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {
                MappedStatement.class,
                Object.class,
                RowBounds.class,
                ResultHandler.class})})
public class PaginationInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);

    public static int MAPPED_STATEMENT_INDEX = 0;
    public static int PARAMETER_INDEX = 1;
    public static int ROWBOUNDS_INDEX = 2;
    public static int RESULT_HANDLER_INDEX = 3;

    public static final RowBounds IS_ROWBOUNDS = new RowBounds();

    /**
     * 方言类名
     */
    private String dialectClass = "com.yqjr.scfw.common.pagination.dialect.OracleDialect";

    public PageBounds getPageBounds(Invocation invocation) {
        final Object[] queryArgs = invocation.getArgs();

        RowBounds rowBounds = (RowBounds) queryArgs[ROWBOUNDS_INDEX];

        if (null == rowBounds) {
            return null;
        }

        return new PageBounds(rowBounds);
    }

    RowBounds getRowBounds(Object value) {

        if (null == value) {
            return null;
        }

        Object singleValue = value;

        if (ObjectUtils.isArray(value)) {

            Object[] arr = (Object[]) value;

            Class<?> componentType = arr.getClass().getComponentType();

            boolean isRowBound = false;

            if (RowBounds.class.isAssignableFrom(componentType)) {
                isRowBound = true;
            }

            if (arr.length == 0) {
                if (isRowBound) {
                    return IS_ROWBOUNDS;
                }
                return null;
            }

            singleValue = arr[0];
        }

        if (singleValue instanceof RowBounds) {
            return (RowBounds) singleValue;
        }

        return null;
    }

    /**
     * correct the invocation
     * @param invocation
     * @throws Throwable
     */
    void prepare(Invocation invocation) throws Throwable {
        final Object[] queryArgs = invocation.getArgs();

        if (null == queryArgs || queryArgs.length % 2 != 0) {
            return;
        }

        final Object parameter = queryArgs[PARAMETER_INDEX];

        if (!(parameter instanceof Map)) {
            return;
        }

        Map paramMap = (Map) parameter;

        RowBounds rowBounds = null;
        RowBounds temp = null;

        List keysToRemove = new ArrayList();

        for (Object key : paramMap.keySet()) {

            Object value = paramMap.get(key);

            temp = getRowBounds(value);

            if (null == temp) {
                continue;
            }

            if (null == rowBounds && temp != IS_ROWBOUNDS) {
                rowBounds = temp;
            }

            keysToRemove.add(key);
        }

        for (Object key : keysToRemove) {
            paramMap.remove(key);
        }

        if (!keysToRemove.isEmpty() && paramMap.size() == 2) {
            queryArgs[PARAMETER_INDEX] = paramMap.values().iterator().next();
        }

        if (null != rowBounds) {
            queryArgs[ROWBOUNDS_INDEX] = rowBounds;
        }

    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        prepare(invocation);

        final Executor executor = (Executor) invocation.getTarget();
        final Object[] queryArgs = invocation.getArgs();
        final MappedStatement ms = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
        final Object parameter = queryArgs[PARAMETER_INDEX];

        final PageBounds pageBounds = getPageBounds(invocation);

        if (null == pageBounds) {
            queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
            return invocation.proceed();
        }

        if (pageBounds.getOffset() == RowBounds.NO_ROW_OFFSET
                && pageBounds.getLimit() == RowBounds.NO_ROW_LIMIT) {
            return invocation.proceed();
        }

        final Dialect dialect = Dialect.forName(dialectClass, new Object[]{ms, parameter, pageBounds});

        final BoundSql boundSql = ms.getBoundSql(parameter);

        queryArgs[MAPPED_STATEMENT_INDEX] = copyFromNewSql(ms, boundSql,
                dialect.getPageSQL(), dialect.getParameterMappings(), dialect.getParameterObject());

        queryArgs[PARAMETER_INDEX] = dialect.getParameterObject();
        queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);

        List resultList = (List) invocation.proceed();

        if (!pageBounds.isContainsTotalCount()) {
            return resultList;
        }

        int count = SQLHelper.getCount(ms, executor.getTransaction(), parameter, boundSql, dialect);

        return new PageList(resultList, pageBounds.getPageNum(), pageBounds.getLimit(), count);
    }

    private MappedStatement copyFromNewSql(MappedStatement ms, BoundSql boundSql,
                                           String sql, List<ParameterMapping> parameterMappings, Object parameter) {
        BoundSql newBoundSql = copyFromBoundSql(ms, boundSql, sql, parameterMappings, parameter);
        return copyFromMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
    }

    private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql,
                                      String sql, List<ParameterMapping> parameterMappings, Object parameter) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, parameterMappings, parameter);
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }

    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }

        //setStatementTimeout()
        builder.timeout(ms.getTimeout());

        //setStatementResultMap()
        builder.parameterMap(ms.getParameterMap());

        //setStatementResultMap()
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());

        //setStatementCache()
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        PropertiesHelper propertiesHelper = new PropertiesHelper(properties);

        String dialectClass = propertiesHelper.getProperty("dialectClass");
        if (null != dialectClass) {
            setDialectClass(dialectClass);
        }
    }

    public void setDialectClass(String dialectClass) {

        if (null == dialectClass) {
            return;
        }

        logger.debug("dialectClass: {} ", dialectClass);
        this.dialectClass = dialectClass;
    }

    public static class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }
}
