package org.langxf.javalab.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class BeanUtils {
	public static final String SET_METHOD = "set";
	public static final String SEP_VLINE = "\\|";
	public static final String SEP_COLON = ":";
	/**
	 * 拆分给定属性字符串，并复制给对应属性。
	 * 属性:value|属性:value...，e.g id:130725198601010015|name:mapleleave|age:34|birthday:1986-01-01
	 * @param obj
	 * @param values
	 */
	public static void setValues(Object obj, String values) {
		if (null == obj || null == values) {
			throw new NullPointerException();
		}
		String[] attributePairs = values.split(SEP_VLINE);
		for (int i = 0; i < attributePairs.length; i++) {
			setValue(obj, attributePairs[i]);
		}
	}

	private static void setValue(Object obj, String attributePairStr) {
		String[] attributePair = attributePairStr.split(SEP_COLON);
		String attributeName = attributePair[0];
		String attributeValue = attributePair[1];
		try {
			Class clazz = obj.getClass();
			Field field = clazz.getDeclaredField(attributeName);

			Method method = clazz.getDeclaredMethod(SET_METHOD + StringUtils.initcap(attributeName), field.getType());
			method.invoke(obj, convertValue(field.getType(), attributeValue));
		} catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据属性类型，将字符串转化成真正类型的值，这里只转化常用类型：
	 * Integer、Long、Double、Boolean、java.util.Date
	 * @param type
	 * @param value
	 * @return
	 */
	public static Object convertValue(Type type, String value) {
		if (null == value || value.trim().equals("")) {
			return value;
		}
		String typeStr = type.getTypeName();
		if ("int".equals(typeStr) || "java.lang.Integer".equals(typeStr)) {
			return Integer.parseInt(value);
		}
		if ("long".equals(typeStr) || "java.lang.Long".equals(typeStr)) {
			return Long.parseLong(value);
		}
		if ("double".equals(typeStr) || "java.lang.Double".equals(typeStr)) {
			return Double.parseDouble(value);
		}
		if ("boolean".equals(typeStr) || "java.lang.Boolean".equals(typeStr)) {
			return Boolean.parseBoolean(value);
		}
		// 此类型需要做yyyy-MM-dd 和 yyyy-MM-dd HH:mm:ss格式的判断
		if ("date".equals(typeStr) || "java.util.Date".equals(typeStr)) {
			return DateUtils.parseDate(value);
		}
		return value;
	}

	private BeanUtils() {}
}



