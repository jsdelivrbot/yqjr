package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.fcsw.meta.api.dto.DictItemDto;
import com.yqjr.fin.scfw.meta.entity.DictItem;
import com.yqjr.fin.scfw.meta.mapper.DictItemMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DictItemService extends BaseService<DictItemMapper, DictItem, Long> {

	/**
	 * 
	 * @param code
	 * @param flag
	 * @param value
	 * @return
	 */
	public List<DictItemDto> getName(String code,Integer flag,String value){
		if(flag==1) {
			value=value.replace(",", "','");
			value="'"+value+"'";
		}
		return mapper.selectItemListbyCode(code, flag, value);
	}
	/**
	 * 
	 * @param code
	 * @param value
	 * @return
	 */
	public List<DictItemDto> getNameByvalue(String code,String value){		
		value="'"+value.replaceAll(",", "','")+"'";
		return  mapper.getNameByvalue(code,value);
	}
}