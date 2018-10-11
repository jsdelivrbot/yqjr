package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.RoleMenu;
import com.yqjr.fin.scfw.meta.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoleMenuService extends BaseService<RoleMenuMapper, RoleMenu, Long> {

}