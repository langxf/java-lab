package org.langxf.javalab.base.reflect.field;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class FieldApiTest {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException, NoSuchFieldException {

		Class<?> clazz = Class.forName("org.langxf.javalab.base.reflect.methodinvoke.Person");
		Object entity = clazz.getDeclaredConstructor().newInstance();

		Field nameField = clazz.getDeclaredField("name");
		// JDK虽然提供API让我们可以访问私有属性，但是这样会破坏封装机制，实际不会使用
		nameField.setAccessible(true);
		nameField.set(entity, "mapleleave");
		System.out.println(nameField.get(entity));

		// 实际会用到的是getName()方法。真实项目中，经常会用Field与Method实现setter方法的调用
		System.out.println(nameField.getType().getName());
		System.out.println(nameField.getType().getSimpleName());
	}
}
