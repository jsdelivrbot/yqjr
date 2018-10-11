package com.yqjr.fin.common.base.starter.util;

import com.yqjr.fin.common.base.starter.enums.ServiceResponseEnum;
import com.yqjr.fin.common.base.starter.exception.InvokeException;
import com.yqjr.fin.common.base.starter.exception.MapTransBeanException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description: 公共方法类
 * @author: lixue
 * @date: 2018/09/06 13:20:49
 **/
@Slf4j
public class CommonUtil {

    /**
     * 反射调用方法
     * @param newObj 实例化的一个对象
     * @param methodName 对象的方法名
     * @param args 参数类型
     * @return 返回值
     * @throws Exception
     */
    public static Object invokeMethod(Object newObj, String methodName, Object[] args) {
        try {
            Class ownerClass = newObj.getClass();
            Class[] argsClass = new Class[args.length];
            for (int i = 0, j = args.length; i < j; i++) {
                argsClass[i] = args[i].getClass();
            }
            Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
            method.setAccessible(true);
            return method.invoke(newObj, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error("反射异常,msg = " +e.getMessage(),e);
            throw new InvokeException(ServiceResponseEnum.INVOKE_EXCEPTION);
        }
    }


}
