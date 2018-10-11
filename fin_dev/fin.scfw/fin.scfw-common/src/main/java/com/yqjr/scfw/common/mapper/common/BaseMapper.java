package com.yqjr.scfw.common.mapper.common;

import com.yqjr.scfw.common.mapper.common.base.BaseSelectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * @author quangz
 */
public interface BaseMapper<T, PK extends Serializable> extends
        BaseSelectMapper<T, PK> {

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @return
     */
    int updateById(T record);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    int patchById(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param id
     * @return
     */
    int deleteById(PK id);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param ids
     * @return
     */
    int deleteByIds(List<PK> ids);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record
     * @return
     */
    int delete(T record);

}
