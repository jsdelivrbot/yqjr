package com.yqjr.scfw.common.controller;

import com.yqjr.scfw.common.Const;
import com.yqjr.scfw.common.entity.BaseEntity;
import com.yqjr.scfw.common.model.pagination.PageInfo;
import com.yqjr.scfw.common.results.ListResultResponse;
import com.yqjr.scfw.common.results.ObjectResultResponse;
import com.yqjr.scfw.common.results.PageResultResponse;
import com.yqjr.scfw.common.service.BaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<Service extends BaseService, Entity> extends ScfwController {
	@Autowired
	protected Service baseService;

	protected ObjectResultResponse<Entity> getObjectResultResponse(boolean isSuccess, String code, String msg, Entity entity) {
		ObjectResultResponse<Entity> result=new ObjectResultResponse<Entity>();
        result.setResult(entity);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
	}
	protected PageResultResponse<Entity> getPageResultResponse(boolean isSuccess, String code, String msg, PageInfo<Entity> pageInfo) {
		PageResultResponse<Entity> result=new PageResultResponse<Entity>();
        result.setPageResult(pageInfo);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
        return result;
	}
	protected ListResultResponse<Entity> getListResultResponse(boolean isSuccess, String code, String msg, List<Entity> list) {
		ListResultResponse<Entity> result=new ListResultResponse<Entity>();
		result.setResult(list);
        result.setIsSuccess(isSuccess);
        result.setCode(code);
        result.setMsg(msg);
		return result;
	}

	@ApiOperation(value = "新增记录（参数：实体对象属性）", tags = "基础删改查：继承自BaseController")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ObjectResultResponse<Entity> add(Entity entity) {
		baseService.insert(entity);
		return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_ADD_SUCCESS, entity);
	}

	@ApiOperation(value = "查询单条记录（参数：主键id）", tags = "基础删改查：继承自BaseController")
	@ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ObjectResultResponse<Entity> get(@PathVariable Long id) {
		Object obj=baseService.selectById(id);
		return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, (Entity)obj);
	}

	@ApiOperation(value = "修改记录（参数：实体对象属性）根据主键更新实体全部字段，null值会被更新", tags = "基础删改查：继承自BaseController")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ObjectResultResponse<Entity> update(Entity entity) {
		baseService.updateById(entity);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
	}

	@ApiOperation(value = "修改记录（参数：实体对象属性）根据主键更新属性不为null的值", tags = "基础删改查：继承自BaseController")
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public ObjectResultResponse<Entity> modify(Entity entity) {
        baseService.updateSelectiveById(entity);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_PUT_SUCCESS, null);
	}

	@ApiOperation(value = "删除记录（参数：主键id）", tags = "基础删改查：继承自BaseController")
	@ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ObjectResultResponse<Entity> remove(@PathVariable int id) {
		baseService.deleteById(id);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_DEL_SUCCESS, null);
	}

	@ApiOperation(value = "删除记录（参数：实体对象属性）", tags = "基础删改查：继承自BaseController")
	@RequestMapping(value = "/del", method = RequestMethod.DELETE)
	public ObjectResultResponse<Entity> del(Entity entity) {
        baseService.delete(entity);
        return this.getObjectResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, Const.MSG_DEL_SUCCESS, null);
	}

	@ApiOperation(value = "查询全部记录", tags = "基础删改查：继承自BaseController")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ListResultResponse<Entity> list() {
        return this.getListResultResponse(Const.SUCCESS, Const.CODE_SUCCESS, null, baseService.selectListAll());
	}

}
