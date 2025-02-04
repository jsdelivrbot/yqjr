package com.yqjr.scfw.common.rest;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.mapper.mapperhelper.EntityHelper;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.results.BaseResultResponse;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.scfw.common.utils.Reflections;
import com.yqjr.scfw.common.vo.Action;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.cglib.core.TypeUtils.upperFirst;

/**
 * @author quangz
 */
public class BaseRest<Service extends BaseService, Entity> extends AbstractRest {
    protected Logger baseLogger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected SmartValidator validator;

    @Autowired
    protected Service baseService;

    @ApiOperation(value = "查询全部记录", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<Entity> getAll() {
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, doGetAll());
    }

    @ApiOperation(value = "新增记录（参数：实体对象属性）", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ObjectResultResponse<Entity> create(@RequestBody Entity entity, Errors errors) {
        Entity created = doCreate(entity, errors);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_ADD_SUCCESS, created);
    }

    @ApiOperation(value = "查询单条记录（参数：主键id）", tags = "基础删改查：继承自BaseRest")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ObjectResultResponse<Entity> get(@PathVariable("id") Long id) {
        Object obj = baseService.selectById(id);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, (Entity) obj);
    }

    @ApiOperation(value = "修改记录（参数：实体对象属性）根据主键更新实体全部字段，null值会被更新", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectResultResponse<Entity> update(@PathVariable("id") Long id,
                                               @RequestBody Entity entity, Errors errors) {
        EntityHelper.setId(entity, id);
        doUpdate(entity, errors);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
    }

    @ApiOperation(value = "修改记录（参数：实体对象属性）根据主键更新属性不为null的值", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ObjectResultResponse<Entity> patch(@PathVariable("id") Long id,
                                              @RequestBody Entity entity, Errors errors) {
        EntityHelper.setId(entity, id);
        doPatch(entity, errors);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
    }

    @ApiOperation(value = "操作（参数：操作对象属性）根据主键对实体进行标准动词以外的操作", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public BaseResultResponse actionById(@PathVariable("id") Long id,
                                         @Valid @RequestBody Action action, Errors errors) {
        Object result = doAction(id, action, errors);
        return getResultResponse(result);
    }

    @ApiOperation(value = "操作（参数：操作对象属性）对实体进行标准动词以外的操作", tags = "基础删改查：继承自BaseRest")
    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public BaseResultResponse action(@Valid @RequestBody Action action, Errors errors) {
        Object result = doAction(action, errors);
        return getResultResponse(result);
    }

    /**
     * directly invoke instance's method
     * @param action
     * @param errors
     * @return
     */
    private Object doAction(Action action, Errors errors) {
        String actionName = action.getName();

        String methodName = "do" + upperFirst(actionName);

        return Reflections.invokeMethod(this, methodName,
                new Class[]{Action.class, Errors.class},
                new Object[]{action, errors});

    }

    /**
     * directly invoke instance's method
     * @param id
     * @param action
     * @param errors
     * @return
     */
    private Object doAction(Long id, Action action, Errors errors) {
        String actionName = action.getName();

        String methodName = "do" + upperFirst(actionName);

        return Reflections.invokeMethod(this, methodName,
                new Class[]{Long.class, Action.class, Errors.class},
                new Object[]{id, action, errors});

    }

    /**
     * directly invoke instance's method
     * @param ids
     * @param action
     * @param errors
     * @return
     */
    private Object doAction(List<Long> ids, Action action, Errors errors) {
        String actionName = action.getName();

        String methodName = "do" + upperFirst(actionName);

        return Reflections.invokeMethod(this, methodName,
                new Class[]{List.class, Action.class, Errors.class},
                new Object[]{ids, action, errors});

    }

    @ApiOperation(value = "删除记录（参数：主键id）", tags = "基础删改查：继承自BaseRest")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectResultResponse<Entity> delete(@PathVariable("id") Long id) {
        doDelete(id);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_DEL_SUCCESS, null);
    }

    @ApiOperation(value = "批量操作记录（参数：主键ids）", tags = "基础删改查：继承自BaseRest")
    @ApiImplicitParam(name = "ids", value = "主键ID列表", required = true, dataType = "java.util.List")
    @RequestMapping(value = "/batch/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public BaseResultResponse batchAction(@PathVariable("ids") List<Long> ids,
                                          @Valid @RequestBody Action action, Errors errors) {
        Object result = doAction(ids, action, errors);

        return getResultResponse(result);
    }

    protected BaseResultResponse getResultResponse(Object result) {
        if (null == result) {
            return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
        }

        if (result instanceof BaseResultResponse) {
            return (BaseResultResponse) result;
        }

        if (result instanceof List) {
            return makeListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, (List) result);
        }

        return this.makeObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, result);
    }

    @ApiOperation(value = "批量查询记录（参数：主键ids）", tags = "基础删改查：继承自BaseRest")
    @ApiImplicitParam(name = "ids", value = "主键ID列表", required = true, dataType = "java.util.List")
    @RequestMapping(value = "/batch/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public ListResultResponse<Entity> batchGet(@PathVariable("ids") List<Long> ids) {
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, doBatchGet(ids));
    }

    @ApiOperation(value = "批量删除记录（参数：主键ids）", tags = "基础删改查：继承自BaseRest")
    @ApiImplicitParam(name = "ids", value = "主键ID列表", required = true, dataType = "java.util.List")
    @RequestMapping(value = "/batch/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectResultResponse<Entity> batchDelete(@PathVariable("ids") List<Long> ids) {
        doBatchDelete(ids);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_DEL_SUCCESS, null);
    }

    /**
     * throws {@link ValidationException} if validation failed
     * @param entity
     * @param errors
     */
    protected void doValidate(Entity entity, Errors errors) {
        validator.validate(entity, errors);

        if(errors.hasErrors()) {
            throw new ValidationException(new BindException((BindingResult) errors));
        }
    }

    protected Entity doCreate(Entity entity, Errors errors) {
        doValidate(entity, errors);
        baseService.insert(entity);
        return entity;
    }

    protected Entity doUpdate(Entity entity, Errors errors) {
        baseService.updateById(entity);
        return entity;
    }

    protected Entity doPatch(Entity entity, Errors errors) {
        baseService.patchById(entity);
        return entity;
    }

    protected void doDelete(Long id) {
        baseService.deleteById(id);
    }

    protected List<Entity> doBatchGet(List<Long> ids) {
        return baseService.selectListByIds(ids);
    }

    protected void doBatchDelete(List<Long> ids) {
        baseService.deleteByIds(ids);
    }

    protected List<Entity> doGetAll() {
        return baseService.selectListAll();
    }

    protected ObjectResultResponse<Entity> getObjectResultResponse(boolean isSuccess, String code, String msg, Entity entity) {
        ObjectResultResponse<Entity> result = new ObjectResultResponse<Entity>();
        result.setResult(entity);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected PageResultResponse<Entity> getPageResultResponse(boolean isSuccess, String code, String msg, PageInfo<Entity> pageInfo) {
        PageResultResponse<Entity> result = new PageResultResponse<Entity>();
        result.setPageResult(pageInfo);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected ListResultResponse<Entity> getListResultResponse(boolean isSuccess, String code, String msg, List<Entity> list) {
        ListResultResponse<Entity> result = new ListResultResponse<Entity>();
        result.setResult(list);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected <T> ObjectResultResponse<T> createGetSuccess(T result) {
        ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
        resultResponse.setResult(result);
        resultResponse.setIsSuccess(Const.SUCCESS);
        resultResponse.setCode(Const.CODE_SUCCESS);
        return resultResponse;
    }
	protected ObjectResultResponse<String> createSuccess() {
		ObjectResultResponse<String> resultResponse = new ObjectResultResponse<>();
		resultResponse.setIsSuccess(Const.SUCCESS);
		resultResponse.setCode(Const.CODE_SUCCESS);
		return resultResponse;
	}
    protected <T> ObjectResultResponse<T> createFalse(String msg) {
        ObjectResultResponse<T> resultResponse = new ObjectResultResponse<>();
        resultResponse.setIsSuccess(Const.FAILURE);
        resultResponse.setCode(Const.CODE_FAILURE);
        resultResponse.setMsg(msg);
        return resultResponse;
    }
}
