package com.yqjr.scfw.common.utils;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Kyll
 * Date: 2016-07-09 15:01
 */
public class BeanUtils {
	private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	/**
	 * 复制对象属性， 已经对常用默认值进行处理。
	 * @param dest 目标对象
	 * @param orig 源对象
	 */
	public static void copyProperties(Object dest, Object orig) {
		ConvertUtils.register(new ByteConverter(null), Byte.class);
		ConvertUtils.register(new CharacterConverter(null), Character.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new DateConverter(null), Date.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);

		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("copy object property failure", e);
		}

		ConvertUtils.deregister();
	}

	/**
	 * 复制对象属性， 采用 CGLIB 机制,  快速。
	 * @param dest 目标对象
	 * @param orig 源对象
	 */
	public static void copyPropertiesByCglib(Object dest, Object orig) {
		Map<String, BeanCopier> BEAN_COPIER_MAP = new HashMap<>();
		String beanKey = dest.getClass().getName() + "_" + orig.getClass().getName();

		BeanCopier copier;
		if (BEAN_COPIER_MAP.containsKey(beanKey)) {
			copier = BEAN_COPIER_MAP.get(beanKey);
		} else {
			copier = BeanCopier.create(orig.getClass(), dest.getClass(), false);
			BEAN_COPIER_MAP.put(beanKey, copier);
		}

		copier.copy(orig, dest, null);
	}
}
