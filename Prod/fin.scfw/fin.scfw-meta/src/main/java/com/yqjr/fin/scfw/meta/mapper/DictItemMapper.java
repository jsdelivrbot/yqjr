package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;
import com.yqjr.fin.scfw.meta.entity.DictItem;

public interface DictItemMapper extends Mapper<DictItem, Long> {
	
	public List<DictItemDto> selectItemListbyCode(@Param("code") String code,@Param("flag") Integer flag,@Param("value") String value);
	public List<DictItemDto> getNameByvalue(@Param("code") String code,@Param("value") String value);	
}
