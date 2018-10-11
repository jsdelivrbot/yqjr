package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.Zone;
import com.yqjr.fin.scfw.meta.mapper.ZoneMapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ZoneService extends BaseService<ZoneMapper, Zone, Long> {

	public List<Zone> getZoneByUserId(Long id){
		return mapper.getZoneByUserId(id);
	}
}