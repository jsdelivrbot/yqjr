package com.yqjr.fin.scfw.isomer.common;

public class Constants {
	// 用于手工在menu表添加数据时父节点url没给#号默认值时使用
	public static final String NO_URL = "#";
	public static final String YES = "1";
	public static final String NO = "0";
	public static final String YES_CN = "是";
	public static final String NO_CN = "否";
	// 显示
	public static final String IS_SHOW = "1";
	// 不显示
	public static final String IS_NOT_SHOW = "0";
	// 根菜单(一级菜单)
	public static final Long MENU_ROOT = 0l;
	// ztree open
	public static final String ZTREE_OPEN = "true";
	public static final String ZTREE_NOT_OPEN = "false";
	// ztree isParent false无子节点的父节点
	public static final String ZTREE_IS_PARENT = "false";
	public static final String ZTREE_IS_NOT_PARENT = "true";
	// 根组织机构（一级组织机构）
	public static final Long OFFICE_ROOT = 0l;
	// otree open
	public static final String OTREE_OPEN = "true";
	public static final String OTREE_NOT_OPEN = "false";
	// otree isParent false无子节点的父节点
	public static final String OTREE_IS_PARENT = "false";
	public static final String OTREE_IS_NOT_PARENT = "true";
	//删除状态
	public static final Long OFFICE_DELFLAG=0l;

	public static final String TABLE_NAME_SYS_DICT = "SYS_DICT";
	public static final String TABLE_NAME_SYS_MENU = "SYS_MENU";
	public static final String TABLE_NAME_SYS_OFFICE = "SYS_OFFICE";

	public static final String EC_UNEXPECT = "07";// 异常分类 不期望的异常
	public static final String EC_SYSTEM = "08";// 异常分类 系统异常

	public static final String ERROR_THREAD_BREAK_OFF = "线程中断";
	public static final String ERROR_CONCURRENT_EXECUTION_FAILURE = "并发执行失败";
	public static final String ERROR_GETTING_BUSINESS_NO_FAILURE= "获取业务序列失败";
	public static final String ERROR_BUSINESS_ID_NO_INITIALIZATION = "该类型业务ID没有初始化";

	public static final String HTTP_METHOD_GET = "get";
	public static final String HTTP_METHOD_POST = "post";

	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_GBK = "GBK";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	public static final String PATTERN_DATE_COMPACT = "yyyyMMdd";
	public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_DATE_TIME_COMPACT = "yyyyMMddHHmmss";

	public static final String ORACLE_PATTERN_DATE = "yyyy-mm-dd";
	public static final String ORACLE_PATTERN_DATE_TIME = "yyyy-mm-dd hh24:mi:ss";
}
