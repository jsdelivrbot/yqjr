package com.yqjr.fin.scfw.zuul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: Kyll
 * Date: 2017-12-03 11:19
 */
@Component
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	

	/**
	 * 添加缓存
	 * @param prefix 前缀，防止键重复
	 * @param key 键
	 * @param value 值
	 * @param expire 过期时间
	 */
	public void add(String prefix, String key, String value, Date expire) {
		redisTemplate.opsForValue().set(prefix+key, value, expire.getTime() - System.currentTimeMillis());
	}

	public boolean exists(String prefix,String key) {
		return redisTemplate.hasKey(prefix+key);
	}
	public void delete(String prefix,String  key) {
		redisTemplate.delete(prefix+key);
	}
}
