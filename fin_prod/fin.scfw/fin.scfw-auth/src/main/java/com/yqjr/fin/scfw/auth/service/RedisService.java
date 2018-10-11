package com.yqjr.fin.scfw.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: Kyll
 * Date: 2017-12-03 11:19
 */
@Service
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	public void add(String prefix,String key, String value, Date expire) {
		redisTemplate.opsForValue().set(prefix+key, value);
		redisTemplate.expire(prefix+key, expire.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public void delete(String prefix,String  key) {
		redisTemplate.delete(prefix+key);
	}

	public boolean exists(String prefix,String  key) {
		return redisTemplate.hasKey(prefix+key);
	}
}
