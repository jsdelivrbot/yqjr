package com.yqjr.fin.risk.stat.mapper;

import com.yqjr.scfw.common.mapper.Mapper;
import com.yqjr.fin.risk.stat.entity.ScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ScheduleJobMapper extends Mapper<ScheduleJob, Long> {

    /**
     * 批量更新状态
     */
    int updateBatch(@Param("ids") String ids,@Param("status") Integer status);
}
