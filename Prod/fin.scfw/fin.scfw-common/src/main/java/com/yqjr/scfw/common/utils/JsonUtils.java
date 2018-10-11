package com.yqjr.scfw.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * JSON 操作工具类
 * @author Yang Lei
 * @version 2016-06-27
 */
public class JsonUtils {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
	}

	/**
	 * 生成集合类型
	 * @param collectionClass 集合类型
	 * @param elementClass 元素类型
	 * @return JSON 转换时所需的 JavaType
	 */
	public static JavaType getCollectionType(Class collectionClass, Class elementClass) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClass);
	}

	/**
	 * 读取 JSON 字符串， 转换为节点树
	 * @param json JSON 字符串
	 * @return JsonNode
	 */
	public static JsonNode jsonToNode(String json) {
		try {
			return mapper.readTree(json);
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return null;
	}

	/**
	 * 读取 JSON 输入流， 转换为节点树
	 * @param inputStream JSON 输入流
	 * @return JsonNode
	 */
	public static JsonNode jsonToNode(InputStream inputStream) {
		try {
			return mapper.readTree(inputStream);
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return null;
	}

	/**
	 * JSON 字符串转换为特定类型对象
	 * @param json JSON 字符串
	 * @param clazz 对象类
	 * @param <T> 对象类型
	 * @return 特定类型对象
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		T t = null;
		try {
			t = mapper.readValue(json, clazz);
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return t;
	}

	/**
	 * JSON 字符串转换为特定类型对象
	 * @param json JSON 字符串
	 * @param clazz 对象类
	 * @param <T> 对象类型
	 * @return
	 * @throws IOException
	 */
	public static <T> T jsonToObjectWithException(String json, Class<T> clazz) throws IOException {
		return mapper.readValue(json, clazz);
	}

	/**
	 * JSON 字符串转换为特定类型对象
	 * @param inputStream JSON 输入流
	 * @param clazz 对象类
	 * @param <T> 对象类型
	 * @return 特定类型对象
	 */
	public static <T> T jsonToObject(InputStream inputStream, Class<T> clazz) {
		T t = null;
		try {
			t = mapper.readValue(inputStream, clazz);
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return t;
	}

	/**
	 * JSON 字符串转换为特定集合类型
	 * @param json JSON 字符串
	 * @param collectionClass 集合类
	 * @param elementClass 元素类
	 * @param <C> 集合类型
	 * @param <E> 元素类型
	 * @return 特定集合类型
	 */
	public static <C, E> C jsonToCollection(String json, Class<C> collectionClass, Class<E> elementClass) {
		try {
			return mapper.readValue(json, getCollectionType(collectionClass, elementClass));
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return null;
	}

	/**
	 * JSON 字符串转换为特定集合类型
	 * @param inputStream JSON 输入流
	 * @param collectionClass 集合类
	 * @param elementClass 元素类
	 * @param <C> 集合类型
	 * @param <E> 元素类型
	 * @return 特定集合类型
	 */
	public static <C, E> C jsonToCollection(InputStream inputStream, Class<C> collectionClass, Class<E> elementClass) {
		try {
			return mapper.readValue(inputStream, getCollectionType(collectionClass, elementClass));
		} catch (IOException e) {
			logger.error("read json failure", e);
		}
		return null;
	}

	/**
	 * 对象转换为字符串
	 * @param object 输入对象
	 * @return String JSON 字符串
	 */
	public static String objectToJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("read json failure", e);
		}
		return null;
	}

	/**
	 * 对象转换为字符串
	 * @param object 输入对象
	 * @return String JSON 字符串
	 * @throws JsonProcessingException
	 */
	public static String objectToJsonWithException(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}
}
