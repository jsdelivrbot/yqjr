package com.yqjr.scfw.common.service;

import com.yqjr.scfw.common.condition.BaseCondition;
import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.scfw.common.mapper.mapperhelper.EntityHelper;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseService<M extends Mapper<T, PK>, T, PK extends Serializable> {
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(BaseCondition<T, PK> condition) {
        return mapper.selectOne(condition);
    }


    public T selectById(PK id) {
        return mapper.selectById(id);
    }


    public List<T> selectListByIds(List<PK> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }

        return mapper.selectByIds(ids);
    }


    public List<T> selectList(BaseCondition<T, PK> condition, PageBounds... pageBounds) {
        return mapper.select(condition, pageBounds);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


//    public Long selectCountAll() {
//        return mapper.selectCount(null);
//    }


    public Long selectCount(BaseCondition<T, PK> condition) {
        return (long) mapper.selectCount(condition);
    }


	/*public void insert(T entity) {

		mapper.insert(entity);
	}*/

    @Transactional(readOnly = false)
    public void insert(T entity) {

        UserContext uc = SessionHolder.getUserContext();
        /*if(uc != null && uc.getId() != null && !uc.getId().equals("")){
            entity.setCreateBy(Long.parseLong(uc.getId()));
			entity.setUpdateBy(Long.parseLong(uc.getId()));
		}
		entity.setCreateDate(new Date());
		entity.setUpdateDate(new Date());*/
        entity = doBeforeInsert(entity);
        mapper.insert(entity);
    }


	/*public void insertSelective(T entity) {
        UserContext uc = SessionHolder.getUserContext();
//		if(uc != null && uc.getId() != null && !uc.getId().equals("")){
//			entity.setCreateBy(Long.parseLong(uc.getId()));
//			entity.setUpdateBy(Long.parseLong(uc.getId()));
//		}
//		entity.setCreateDate(new Date());
//		entity.setUpdateDate(new Date());
		mapper.insertSelective(entity);
	}*/

    @Transactional(readOnly = false)
    public void delete(T entity) {
        mapper.delete(entity);
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional(readOnly = false)
    public void deleteById(PK id) {
        mapper.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Transactional(readOnly = false)
    public void deleteByIds(List<PK> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        mapper.deleteByIds(ids);
    }


    @Transactional(readOnly = false)
    public void updateById(T entity) {
        UserContext uc = SessionHolder.getUserContext();
		/*if(uc != null && uc.getId() != null && !uc.getId().equals("")){
			entity.setUpdateBy(Long.parseLong(uc.getId()));
		}
		entity.setUpdateDate(new Date());*/
        entity = doBeforeUpdate(entity);
        mapper.updateById(entity);
    }

    /**
     * user {@link #patchById(Object)} instead
     *
     * @param entity
     */
    @Deprecated
    public void updateSelectiveById(T entity) {
        this.patchById(entity);

    }

    @Transactional(readOnly = false)
    public void patchById(T entity) {
        UserContext uc = SessionHolder.getUserContext();
		/*if(uc != null && uc.getId() != null && !uc.getId().equals("")){
			entity.setUpdateBy(Long.parseLong(uc.getId()));
		}
		entity.setUpdateDate(new Date());*/
        entity = doBeforeUpdate(entity);
        mapper.patchById(entity);

    }

    /**
     * 根据ids批量删除
     */
    @Transactional(readOnly = false)
    public Integer deleteBatchByIds(List<PK> ids, String property, Class<T> clazz) {
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        return mapper.deleteByIds(ids);
    }


//    public void updateBatch(List<T> entitys) {
//        mapper.batchUpdate(entitys);
//    }

    /**
     * @param old
     * @param cur
     * @param model
     * @return
     * @Description 校验属性是否重复
     * @Title checkUnique
     */
    public String checkUnique(String old, String cur, T model) {

        if (cur != null && cur.equals(old)) {
            return "true";
        }

        BaseCondition<T, PK> condition = EntityHelper.condition(model);
        if (cur != null && selectOne(condition) == null) {
            return "true";
        }
        return "false";
    }

    protected T doBeforeInsert(T entity) {
        EntityHelper.setCreateInfo(entity);
        return entity;
    }

    protected T doBeforeUpdate(T entity) {
        PK id = (PK) EntityHelper.getPK(entity);
        T oldEntity = selectById(id);
        doBeforeUpdate(entity, oldEntity);
        return entity;
    }

    protected T doBeforeUpdate(T entity, T oldEntity) {
        setModifyInfo(entity, oldEntity);
        return entity;
    }

    protected void setModifyInfo(T entity, T oldEntity) {
        Long oldCreator = EntityHelper.getCreator(oldEntity);
        Date oldCreateTime = EntityHelper.getCreateTime(oldEntity);

        EntityHelper.setCreateUpdateInfo(entity, true, oldCreator, oldCreateTime);
        EntityHelper.setModifyInfo(entity);
    }

}
