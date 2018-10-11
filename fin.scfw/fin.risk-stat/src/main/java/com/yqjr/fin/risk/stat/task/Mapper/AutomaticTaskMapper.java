package com.yqjr.fin.risk.stat.task.Mapper;


import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AutomaticTaskMapper {

   public void autoRunDay(Map<String, Object> paramMap);

   public void autoRunMonth(Map<String, Object> paramMap);
	
}
