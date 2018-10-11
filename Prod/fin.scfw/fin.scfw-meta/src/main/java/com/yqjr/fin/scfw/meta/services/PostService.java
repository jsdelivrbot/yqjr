package com.yqjr.fin.scfw.meta.services;

import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.scfw.meta.entity.Post;
import com.yqjr.fin.scfw.meta.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostService extends BaseService<PostMapper, Post, Long> {


}