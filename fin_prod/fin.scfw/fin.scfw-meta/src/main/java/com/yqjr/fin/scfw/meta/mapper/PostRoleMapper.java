package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;

import java.util.List;


import com.yqjr.fin.scfw.meta.entity.PostRole;

public interface PostRoleMapper extends Mapper<PostRole, Long> {

	public List<Integer> selectByPostId(Integer postId);
	
}
