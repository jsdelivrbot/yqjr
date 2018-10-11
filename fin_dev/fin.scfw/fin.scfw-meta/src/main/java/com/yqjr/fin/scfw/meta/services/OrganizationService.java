package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.Organization;
import com.yqjr.fin.scfw.meta.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrganizationService extends BaseService<OrganizationMapper, Organization, Long> {
}