package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.OrganizationPost;
import com.yqjr.fin.scfw.meta.mapper.OrganizationPostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrganizationPostService extends BaseService<OrganizationPostMapper, OrganizationPost, Long> {
}