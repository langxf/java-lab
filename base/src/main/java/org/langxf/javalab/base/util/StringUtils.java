package org.langxf.javalab.base.util;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class StringUtils {
	/**
	 * 首字母大写
	 * @param value
	 * @return
	 */
	public static String initcap(String value) {
		if (null == value || value.length() == 0) {
			return value;
		}
		if (value.length() == 1) {
			return value.toUpperCase();
		}
		StringBuilder builder = new StringBuilder(value.substring(0, 1).toUpperCase());
		builder.append(value.substring(1));
		return builder.toString();
	}

	private StringUtils() {}
}
