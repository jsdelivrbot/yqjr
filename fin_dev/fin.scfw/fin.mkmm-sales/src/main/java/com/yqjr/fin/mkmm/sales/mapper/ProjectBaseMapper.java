package com.yqjr.fin.mkmm.sales.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.mkmm.sales.entity.ProjectBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectBaseMapper extends Mapper<ProjectBase, Long> {


    public ProjectBase selectByProjectName(ProjectBase projectBase);

    /**
     * 查询项目编码最大ID
     * @param company
     * @return
     */
    String queryMax(String company);
}
