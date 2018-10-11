package com.yqjr.fin.scfw.meta.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import java.util.List;
import com.yqjr.fin.scfw.meta.entity.Post;

public interface PostMapper extends Mapper<Post, Long> {

	public List<Post> selectByPostId(Integer postId);
}
