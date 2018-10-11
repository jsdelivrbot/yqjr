package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import java.util.List;
import com.yqjr.fin.scfw.meta.entity.UserPost;

public interface UserPostMapper extends Mapper<UserPost, Long> {

	public List<Integer> selectByUserId(Integer userId);
	
}
