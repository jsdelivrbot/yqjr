package com.yqjr.fin.risk.stat.task;

import com.yqjr.fin.risk.stat.task.Mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaskMapper taskMapper;

	public void test(String params){
		System.out.println("----------------------");
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		Map<String,Object> map= new HashMap<>();
		map.put("p_theyear",2018);
		map.put("p_themonth",06);
			//taskMapper.custom_r0401003(map);
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		SysUserEntity user = sysUserService.selectById(1L);
//		System.out.println(ToStringBuilder.reflectionToString(user));

	}


	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
	}
}
