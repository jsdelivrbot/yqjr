package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.System;
import com.yqjr.fin.scfw.meta.mapper.SystemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ServiceService extends BaseService<SystemMapper, System, Long> {
//暂时不用 继承错误

}