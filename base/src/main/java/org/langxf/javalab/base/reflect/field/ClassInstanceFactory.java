package org.langxf.javalab.base.reflect.field;

import org.langxf.javalab.base.util.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class ClassInstanceFactory<T> {
	public static ClassInstanceFactory getInstance() {
		return ClassInstanceFactoryHolder.instance;
	}

	public static <T> T create(String classPath, String values) {
		Class clazz = null;
		try {
			clazz = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) create(clazz, values);
	}

	public static <T> T create(Class<T> clazz, String values) {
		T t = null;
		try {
			t = clazz.getDeclaredConstructor().newInstance();
			BeanUtils.setValues(t, values);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return t;
	}

	private ClassInstanceFactory() {}
	private static class ClassInstanceFactoryHolder {
		private static volatile ClassInstanceFactory instance = new ClassInstanceFactory();
	}
}