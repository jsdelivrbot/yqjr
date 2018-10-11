package com.yqjr.scfw.common.mapper.common.base;

import com.yqjr.scfw.common.condition.BaseCondition;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author quangz
 */
public interface BaseSelectMapper<T, PK extends Serializable> {
    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param condition
     * @return
     */
    T selectOne(BaseCondition<T, PK> condition);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param condition
     * @return
     */
    List<T> select(BaseCondition<T, PK> condition, PageBounds... pageBounds);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param condition
     * @param sortField
     * @param isAscend
     * @return
     */
    List<T> selectOrderBy(BaseCondition<T, PK> condition,
                          @Param("sortField") String sortField,
                          @Param("isAscend") boolean isAscend, PageBounds... pageBounds);

    /**
     * 根据属性查询记录
     *
     * @param propName
     * @param propValue
     * @return
     */
    List<T> selectByProperty(@Param("propName") String propName,
                             @Param("propValue") Object propValue, PageBounds... pageBounds);

    /**
     * 根据属性查询记录
     *
     * @param propName
     * @param propValues
     * @return
     */
    List<T> selectByPropertyIn(@Param("propName") String propName,
                               @Param("propValues") List propValues, PageBounds... pageBounds);

    /**
     * 查询全部结果
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param condition
     * @return
     */
    int selectCount(BaseCondition<T, PK> condition);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key
     * @return
     */
    T selectById(PK key);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号，
     * 调用端需要检查传入的ids列表不空！
     *
     * @param ids id列表
     * @return
     */
    List<T> selectByIds(List<PK> ids);
}
