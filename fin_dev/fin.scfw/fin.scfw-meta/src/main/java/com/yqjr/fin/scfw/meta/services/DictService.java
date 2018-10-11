package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.Dict;
import com.yqjr.fin.scfw.meta.mapper.DictMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DictService extends BaseService<DictMapper, Dict, Long> {

}