package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.fin.scfw.meta.condition.MenuCondition;
import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.yqjr.fin.scfw.meta.entity.Menu;

public interface MenuMapper extends Mapper<Menu, Long> {

	public List<Menu> selectById(Integer id);
	public List<Menu> selectMenuList(@Param("roleIdList") String roleIdList,@Param("sysId") Long sysId);
	//	public List<Menu> selectMenuList(@Parameter("id") Long id,Long sysId);

	public List<MenuCondition> selectMenUList(@Param("roleIdList") String roleIdList, @Param("sysId") Long sysId);
}
