package com.lybj.util.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


public class BeanUtils {
    /**
     * bean 转化为实体
     *
     * @param bean
     * @return
     */
    public static HashMap<String, Object> beanToMap(Object bean) throws InvocationTargetException,
            IllegalAccessException, IntrospectionException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (null == bean) {
            return map;
        }
        Class<?> clazz = bean.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);   //这里也可以用反射自己写

        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            String propertyName = descriptor.getName();
            if (!"class".equals(propertyName)) {
                Method method = descriptor.getReadMethod();
                Object result;
                result = method.invoke(bean);
                if (null != result) {
                    map.put(propertyName, result);
                } else {
                    map.put(propertyName, "");
                }
            }
        }
        return map;
    }

    /**
     * map 转化为 bean
     *
     * @param clazz
     * @param map
     * @return
     */

    public static Object mapToBean(Class clazz, HashMap map) throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Object object = clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                Object value = map.get(propertyName);
                Object[] args = new Object[1];
                args[0] = value;
                descriptor.getWriteMethod().invoke(object, args);
            }
        }
        return object;
    }
}  