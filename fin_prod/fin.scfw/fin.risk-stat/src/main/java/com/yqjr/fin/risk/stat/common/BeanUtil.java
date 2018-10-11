package com.yqjr.fin.risk.stat.common;

import net.sf.cglib.beans.BeanCopier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Kyll
 * Date: 2017-06-02 15:55
 */
public class BeanUtil {
	private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	/**
	 * 复制对象属性， 采用 CGLIB 机制。
	 * @param dest 目标对象
	 * @param orig 源对象
	 */
	public static void copyProperties(Object dest, Object orig) {
		Map<String, BeanCopier> BEAN_COPIER_MAP = new HashMap<String, BeanCopier>();
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

	public static boolean hasField(Object object, String fieldName) {
		return getFieldByName(object, fieldName) != null;
	}

	public static Field getFieldByName(Object object, String fieldName) {
		return getFieldByName(object.getClass(), fieldName);
	}

	public static Field getFieldByName(Class clazz, String fieldName) {
		Field field = null;
		try {
			field = clazz.getField(fieldName);
		} catch (NoSuchFieldException e) {
		} catch (Exception e) {
			logger.error("通过属性名称获取Field异常", e);
		}
		return field;
	}

	public static List<Method> getGetMethodList(Class clazz) {
		return getMethodList(clazz, "get");
	}

	public static List<Method> getSetMethodList(Class clazz) {
		return getMethodList(clazz, "set");
	}

	public static List<Method> getMethodList(Class clazz, String prefix) {
		List<Method> methodList = new ArrayList<Method>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getName().startsWith(prefix)) {
				methodList.add(method);
			}
		}
		return methodList;
	}

	public static String getGetMethodNameByFieldName(String fieldName) {
		return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
	}

	public static String getSetMethodNameByFieldName(String fieldName) {
		return "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
	}

	public static String getFieldNameByMethodName(String methodName) {
		String fieldName = methodName.substring(methodName.startsWith("is") ? 2 : 3);
		return Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
	}

	@SuppressWarnings("unchecked")
	public static Method getGetMethodByFieldName(Class clazz, String fieldName) {
		Method method = null;
		try {
			method = clazz.getMethod(BeanUtil.getGetMethodNameByFieldName(fieldName));
		} catch (NoSuchMethodException ignored) {
		} catch (Exception e) {
			logger.error("通过属性名称获取Get方法异常", e);
		}
		return method;
	}

	@SuppressWarnings("unchecked")
	public static Method getSetMethodByFieldName(Class clazz, String fieldName) {
		return getMethodByName(clazz, getSetMethodNameByFieldName(fieldName));
	}

	public static Method getMethodByName(Class clazz, String name) {
		for (Method method : clazz.getMethods()) {
			if (method.getName().equalsIgnoreCase(name)) {
				return method;
			}
		}
		return null;
	}

	public static Object invokeGetMethod(Object object, String fieldName) {
		return invoke(object, BeanUtil.getGetMethodByFieldName(object.getClass(), fieldName));
	}

	public static void invokeSetMethod(Object object, String fieldName, Object value) {
		invoke(object, BeanUtil.getSetMethodByFieldName(object.getClass(), fieldName), value);
	}

	public static Object invoke(Object object, Method method, Object... args) {
		try {
			return method.invoke(object, args);
		} catch (IllegalAccessException ignored) {
		} catch (InvocationTargetException ignored) {
		} catch (Exception e) {
			logger.error("调用方法异常", e);
		}
		return null;
	}

	public static Class getGenericEntityClass(Object object) {
		ParameterizedType parameterizedType = (ParameterizedType) object.getClass().getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		return types == null ? null : (Class) types[0];
	}

	public static <T> T newInstance(Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException ignored) {
		} catch (IllegalAccessException ignored) {
		} catch (Exception e) {
			logger.error("创建实例异常", e);
		}
		return t;
	}

	public static <T> T newInstance(Class<T> clazz, Object orig) {
		T t = newInstance(clazz);
		copyProperties(t, orig);
		return t;
	}

	public static Object getPrivateValue(Object object, String fieldName) {
		Object value = null;
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			value = field.get(object);
		} catch (NoSuchFieldException ignored) {
		} catch (IllegalAccessException ignored) {
		} catch (Exception e) {
			logger.error("获取私有属性值异常", e);
		}

		return value;
	}
}
