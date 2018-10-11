package com.yqjr.scfw.common.mapper.mapperhelper;

import com.yqjr.scfw.common.condition.BaseCondition;
import com.yqjr.scfw.common.mapper.model.EntityColumn;
import com.yqjr.scfw.common.mapper.model.EntityField;
import com.yqjr.scfw.common.mapper.model.EntityTable;
import com.yqjr.scfw.common.session.SessionHolder;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author quangz
 */
public class EntityHelper {

    private static final Logger logger = LoggerFactory.getLogger(EntityHelper.class);

    public static final String PROP_CCOMPANY = "company";
    public static final String PROP_CREATOR = "creator";
    public static final String PROP_CREATE_TIME = "createTime";
    public static final String PROP_MODIFIER = "modifier";
    public static final String PROP_MODIFY_TIME = "modifyTime";

    public static final String DEFAULT_PK_NAME = "id";

    public static final EntityHelper INSTANCE = new EntityHelper();
    public static final String PK_COLUMN_NAME = "id";

    private final Map<Class<?>, Set<String>> entityPKPropMap = new HashMap<>();

    private final Map<Class<?>, Map<String, EntityColumn>> entityPropertyMap = new HashMap<>();

    /**
     * 实体类 => 表对象
     */
    private static final Map<Class<?>, EntityTable> entityTableMap = new HashMap<Class<?>, EntityTable>();

    public static Map<Class<?>, Set<String>> entityPKPropMap() {
        return INSTANCE.entityPKPropMap;
    }

    public static Map<Class<?>, Map<String, EntityColumn>> entityPropertyMap() {
        return INSTANCE.entityPropertyMap;
    }

    /**
     * 获取主键信息
     *
     * @param entity
     * @return
     */
    public static Set<EntityColumn> getPKColumns(Object entity) {
        if (null == entity) {
            return Collections.emptySet();
        }
        return getPKColumns(entity.getClass());
    }

    /**
     * 获取主键信息
     *
     * @param entityClass
     * @return
     */
    public static Set<EntityColumn> getPKColumns(Class<?> entityClass) {
        return getEntityTable(entityClass).getEntityClassPKColumns();
    }

    /**
     * 获取id属性列表
     *
     * @param entity
     * @return
     */
    public static Set<String> getPKPropNames(Object entity) {
        if (null == entity) {
            return Collections.emptySet();
        }
        return getPKPropNames(entity.getClass());
    }

    /**
     * 获取id名
     *
     * @param entity
     * @return
     */
    public static String getPKPropName(Object entity) {
        return getPKPropNames(entity).iterator().next();
    }

    /**
     * 获取id名
     *
     * @param entityClass
     * @return
     */
    public static String getPKPropName(Class<?> entityClass) {
        return getPKPropNames(entityClass).iterator().next();
    }

    /**
     * 设置实体主键
     *
     * @param entity
     * @param pk
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void setPK(Object entity, Object pk) {
        try {
            PropertyUtils.setProperty(entity, getPKPropName(entity), pk);
        } catch (Exception e) {
            logger.error("error setPK", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置实体id
     *
     * @param entity
     * @param id
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void setId(Object entity, Object id) {
        try {
            PropertyUtils.setProperty(entity, "id", id);
        } catch (Exception e) {
            logger.error("error setId", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据属性名获取相应的列名
     *
     * @param entityClass
     * @param propName
     * @return
     */
    public static String getColumnName(Class<?> entityClass, String propName) {
        Map<String, EntityColumn> propertyMap = getPropertyMap(entityClass);

        if (null != propertyMap && propertyMap.containsKey(propName)) {
            return propertyMap.get(propName).getColumn();
        }

        return null;
    }

    public static Map<String, EntityColumn> getPropertyMap(Class<?> entityClass) {
        Map<Class<?>, Map<String, EntityColumn>> entityPropertyMap = entityPropertyMap();
        Map<String, EntityColumn> propertyMap = entityPropertyMap.get(entityClass);

        if (null != propertyMap) {
            return propertyMap;
        }

        Set<EntityColumn> columns = getColumns(entityClass);
        propertyMap = new HashMap<>(columns.size());
        for (EntityColumn column : columns) {
            propertyMap.put(column.getProperty(), column);
        }

        entityPropertyMap.put(entityClass, propertyMap);

        return propertyMap;
    }

    /**
     * 获取全部列
     *
     * @param entityClass
     * @return
     */
    public static Set<EntityColumn> getColumns(Class<?> entityClass) {
        return getEntityTable(entityClass).getEntityClassColumns();
    }

    /**
     * 获取表对象
     *
     * @param entityClass
     * @return
     */
    public static EntityTable getEntityTable(Class<?> entityClass) {
        EntityTable entityTable = entityTableMap.get(entityClass);
        if (entityTable == null) {
            throw new RuntimeException("无法获取实体类" + entityClass.getCanonicalName() + "对应的表名!");
        }
        return entityTable;
    }

    public static void processConfiguration(org.mybatis.spring.mapper.MapperFactoryBean mapperFactoryBean,
                                            Configuration configuration, Class<?> mapperInterface) {

        initEntityNameMap(mapperFactoryBean, configuration, mapperInterface);
    }

    /**
     * 初始化实体属性
     *
     * @param mapperFactoryBean
     */
    public static synchronized void initEntityNameMap(org.mybatis.spring.mapper.MapperFactoryBean mapperFactoryBean,
                                                      Configuration configuration, Class<?> mapperInterface) {
        String namespace = mapperInterface.getName();

        String idPrefix = namespace + ".";

        ResultMap resultMap = configuration.getResultMap(idPrefix + "BaseResultMap");

        Class<?> entityClass = resultMap.getType();

        if (entityTableMap.get(entityClass) != null) {
            return;
        }


        Map<String, XNode> sqlFragments = configuration.getSqlFragments();
        XNode tableNameNode = sqlFragments.get(idPrefix + "Base_Table_Name");
        String tableName = StringUtils.trim(tableNameNode.getStringBody());

        //创建并缓存EntityTable
        EntityTable entityTable = new EntityTable(entityClass);
        entityTable.setName(tableName);
        entityTable.setEntityClassColumns(new LinkedHashSet<EntityColumn>());
        entityTable.setEntityClassPKColumns(new LinkedHashSet<EntityColumn>());

        //处理所有列

        List<ResultMapping> resultMappings = resultMap.getResultMappings();

        Map<String, ResultMapping> propNameToResultMapping = new HashMap<>(resultMappings.size());

        for (ResultMapping resultMapping : resultMappings) {
            propNameToResultMapping.put(resultMapping.getProperty(), resultMapping);
        }

        List<EntityField> fields = FieldHelper.getFields(entityClass);

        for (EntityField field : fields) {
            processField(entityTable, field, propNameToResultMapping, resultMap);
        }

        //当pk.size=0的时候使用所有列作为主键
        if (entityTable.getEntityClassPKColumns().size() == 0) {
            entityTable.setEntityClassPKColumns(entityTable.getEntityClassColumns());
        }
        entityTableMap.put(entityClass, entityTable);
    }

    /**
     * 处理一列
     *
     * @param entityTable
     * @param field
     * @param resultMap
     */
    private static void processField(EntityTable entityTable, EntityField field,
                                     Map<String, ResultMapping> propNameToResultMapping,
                                     ResultMap resultMap) {

        String propName = field.getName();
        ResultMapping resultMapping = propNameToResultMapping.get(propName);
        if (null == resultMapping) {
            return;
        }

        //Id
        EntityColumn entityColumn = new EntityColumn(entityTable);
        if (PK_COLUMN_NAME.equals(propName)) {
            entityColumn.setId(true);
        }
        //Column
        String columnName = resultMapping.getColumn();

        entityColumn.setJdbcType(resultMapping.getJdbcType());
        entityColumn.setJavaType(resultMapping.getJavaType());
//        entityColumn.setTypeHandler(resultMapping.getTypeHandler());

        //表名
        entityColumn.setProperty(propName);
        entityColumn.setColumn(columnName);
        entityColumn.setJavaType(field.getJavaType());

        //主键策略 - Oracle序列，MySql自动增长，UUID
        /*if (field.isAnnotationPresent(SequenceGenerator.class)) {
            SequenceGenerator sequenceGenerator = field.getAnnotation(SequenceGenerator.class);
            if (sequenceGenerator.sequenceName().equals("")) {
                throw new RuntimeException(entityTable.getEntityClass() + "字段" + propName + "的注解@SequenceGenerator未指定sequenceName!");
            }
            entityColumn.setSequenceName(sequenceGenerator.sequenceName());
        } else if (field.isAnnotationPresent(GeneratedValue.class)) {
            GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
            if (generatedValue.generator().equals("UUID")) {
                entityColumn.setUuid(true);
            } else if (generatedValue.generator().equals("JDBC")) {
                entityColumn.setIdentity(true);
                entityColumn.setGenerator("JDBC");
                entityTable.setKeyProperties(entityColumn.getProperty());
                entityTable.setKeyColumns(entityColumn.getColumn());
            } else {
                //允许通过generator来设置获取id的sql,例如mysql=CALL IDENTITY(),hsqldb=SELECT SCOPE_IDENTITY()
                //允许通过拦截器参数设置公共的generator
                if (generatedValue.strategy() == GenerationType.IDENTITY) {
                    //mysql的自动增长
                    entityColumn.setIdentity(true);
                    if (!generatedValue.generator().equals("")) {
                        String generator = null;
                        IdentityDialect identityDialect = IdentityDialect.getDatabaseDialect(generatedValue.generator());
                        if (identityDialect != null) {
                            generator = identityDialect.getIdentityRetrievalStatement();
                        } else {
                            generator = generatedValue.generator();
                        }
                        entityColumn.setGenerator(generator);
                    }
                } else {
                    throw new RuntimeException(propName
                            + " - 该字段@GeneratedValue配置只允许以下几种形式:" +
                            "\n1.全部数据库通用的@GeneratedValue(generator=\"UUID\")" +
                            "\n2.useGeneratedKeys的@GeneratedValue(generator=\\\"JDBC\\\")  " +
                            "\n3.类似mysql数据库的@GeneratedValue(strategy=GenerationType.IDENTITY[,generator=\"Mysql\"])");
                }
            }
        }*/

        entityTable.getEntityClassColumns().add(entityColumn);
        if (entityColumn.isId()) {
            entityTable.getEntityClassPKColumns().add(entityColumn);
        }
    }

    /**
     * 获取id属性列表
     *
     * @param entityClass
     * @return
     */
    public static Set<String> getPKPropNames(Class<?> entityClass) {

        Set<String> pkPropNames = entityPKPropMap().get(entityClass);

        if (null != pkPropNames) {
            return pkPropNames;
        }

        Set<String> propNames = new HashSet<>();
        try {
            Set<EntityColumn> pkColumns = getPKColumns(entityClass);
            for (EntityColumn pkColumn : pkColumns) {
                String propName = pkColumn.getProperty();
                propNames.add(propName);
            }
        } catch (Exception e) {
            propNames.add(DEFAULT_PK_NAME);
        }

        entityPKPropMap().put(entityClass, propNames);

        return propNames;
    }

    /**
     * 获取主键列表
     *
     * @param entity
     * @return
     */
    public static Map getPKs(Object entity) {
        Set<String> pkPropNames = getPKPropNames(entity);

        if (CollectionUtils.isEmpty(pkPropNames)) {
            return null;
        }

        Map pks = new HashMap(pkPropNames.size());

        for (String propName : pkPropNames) {
            try {
                pks.put(propName, PropertyUtils.getProperty(entity, propName));
            } catch (Exception e) {
                logger.error("error getPKs", e);
                throw new RuntimeException(e);
            }
        }

        return pks;
    }

    /**
     * 获取实体的主键
     *
     * @param entity
     * @return
     */
    public static Object getPK(Object entity) {
        Map pks = getPKs(entity);

        if (CollectionUtils.isEmpty(pks)) {
            return null;
        }

        return pks.values().iterator().next();
    }

    /**
     * 获取实体列表的主键列表
     *
     * @param entities
     * @return
     */
    public static List getPKs(List entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        List pks = new ArrayList(entities.size());

        for (Object entity : entities) {
            pks.add(getPK(entity));
        }

        return pks;
    }

    public static <T, PK> BaseCondition<T, PK> condition(T model) {
        BaseCondition<T, PK> condition = condition(model.getClass());

        try {
            PropertyUtils.copyProperties(condition, model);
        } catch (Exception e) {
            throw new RuntimeException("can not create condition", e);
        }

        return condition;
    }

    public static <T, PK> BaseCondition<T, PK> condition(Class<?> entityClass) {
        String[] parts = entityClass.getName().split("\\.entity\\.");

        if (parts.length != 2) {
            return null;
        }

        String conditionClassName = org.springframework.util.StringUtils.arrayToDelimitedString(new String[]{
                parts[0], "condition", parts[1] + "Condition"
        }, ".");

        Class<?> conditionClass = null;
        try {
            conditionClass = Class.forName(conditionClassName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return (BaseCondition<T, PK>) BeanUtils.instantiate(conditionClass);
    }

    /**
     * set creator and createTime
     *
     * @param entity
     */
    public static void setCreateInfo(Object entity) {
        setCreateUpdateInfo(entity, true, SessionHolder.getUserId());
    }

    public static void setCreateUpdateInfo(Object entity, boolean isCreate, Long userId) {
        setCreateUpdateInfo(entity, isCreate, userId, new Date());
    }

    public static void setCreateUpdateInfo(Object entity, boolean isCreate, Long userId, Date date) {
        String propUserId = isCreate ? PROP_CREATOR : PROP_MODIFIER;
        String propTime = isCreate ? PROP_CREATE_TIME : PROP_MODIFY_TIME;
        String propCompany = isCreate ? PROP_CCOMPANY:PROP_CCOMPANY ;

        if (null == userId) {
            userId = SessionHolder.getUserId();
        }

        if (null == date) {
            date = new Date();
        }

        String company = SessionHolder.getCompany();

        if (PropertyUtils.isWriteable(entity, propUserId)) {
            try {
                PropertyUtils.setProperty(entity, propUserId, userId);
                PropertyUtils.setProperty(entity, propTime, date);
//                PropertyUtils.setProperty(entity, propCompany, company);

            } catch (Exception e) {
                logger.error("error while set create info", e);
            }
        }
    }

    /**
     * 获取实体的创建人
     *
     * @param entity
     * @return
     */
    public static Long getCreator(Object entity) {
        try {
            return (Long) PropertyUtils.getProperty(entity, PROP_CREATOR);
        } catch (Exception e) {
            logger.error("error while get creator", e);
        }

        return null;
    }

    /**
     * 获取实体的创建时间
     *
     * @param entity
     * @return
     */
    public static Date getCreateTime(Object entity) {
        try {
            return (Date) PropertyUtils.getProperty(entity, PROP_CREATE_TIME);
        } catch (Exception e) {
            logger.error("error while get createTime", e);
        }

        return null;
    }

    /**
     * set modifier and modifyTime
     *
     * @param entity
     */
    public static void setModifyInfo(Object entity) {
        setCreateUpdateInfo(entity, false, SessionHolder.getUserId());
    }
}
