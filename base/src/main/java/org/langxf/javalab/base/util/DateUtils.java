package org.langxf.javalab.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class DateUtils {
	// 日期格式相关常量
	public static final String DATE_PATTERN_DATE = "\\d{4}-\\d{2}-\\d{2}";
	public static final String DATE_PATTERN_TIME = DATE_PATTERN_DATE + " \\d{2}:\\d{2}:\\d{2}";
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
	public static final String DATE_FORMAT_TIME = DATE_FORMAT_DATE + " HH:mm:ss";

	private static final ThreadLocal<SimpleDateFormat> threadLocalDate = ThreadLocal.withInitial(
			() -> new SimpleDateFormat(DATE_FORMAT_DATE)
	);
	private static final ThreadLocal<SimpleDateFormat> threadLocalTime = ThreadLocal.withInitial(
			() -> new SimpleDateFormat(DATE_FORMAT_TIME)
	);

	public static Date parseDate(String value) {
		Date date = null;
		try {
			if (value.matches(DATE_PATTERN_DATE)) {
				date = threadLocalDate.get().parse(value);
			} else if (value.matches(DATE_FORMAT_TIME)) {
				date = threadLocalTime.get().parse(value);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		return date;
	}

	public DateUtils() {}
}
