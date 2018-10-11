package com.yqjr.scfw.common.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;


/**
 * 
 * ClassName: CommonUtils <br>
 * Description: 通用工具类 <br>
 * Create By: Wanglei <br>
 * Create Date: 2017年6月6日 上午10:25:48 <br>
 * Modified By: <br>
 * Modified Date: <br>
 * Modified Content: <br>
 * Version: 1.0 <br>
 *
 */
public class CommonUtils {

	/**
	 * 
	 * Description: 金额转换 <br>
	 * Create By: Wanglei <br>
	 * Create Date: 2017年7月10日 下午2:57:56
	 *
	 * @param amount
	 * @return
	 */
	public static String formatMoney(BigDecimal amount) {
		if (null == amount) {
			amount = new BigDecimal(0.00);
		}
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("###,##0.00");
		return myformat.format(amount);
	}

	/**
	 * 判断实体类是否存在某个属性
	 * @param clazz 实体类
	 * @param attributeName 实体类属性
	 * @return
	 */
	public static boolean checkEntityAttributeIsExist(Class clazz,String attributeName){
		boolean isExist=false;
		Field[] fields=clazz.getDeclaredFields();
		for (Field field:fields) {
			if(field.getName().equals(attributeName)){
				isExist=true;
				break;
			}
		}
		return isExist;
	}
}
