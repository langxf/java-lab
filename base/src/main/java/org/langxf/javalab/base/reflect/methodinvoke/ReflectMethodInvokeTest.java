package org.langxf.javalab.base.reflect.methodinvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Langxf
 * @date 2020/12/19
 * 演示反射调用 Person 类的 getter/setter
 */
public class ReflectMethodInvokeTest {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException, ClassNotFoundException {

		// 这里可以通过不导包，直接通过字符串类全路径加载类，避免了耦合
		// 数据库驱动类一般就是这么加载的
		Class<?> clazz = Class.forName("org.langxf.javalab.base.reflect.methodinvoke.Person");
		Object obj = clazz.getDeclaredConstructor().newInstance();
		String value = "mapleleave";

		String setMethodName = "setName";
		Method setMethod = clazz.getDeclaredMethod(setMethodName, String.class);
		setMethod.invoke(obj, value);

		String getMethodName = "getName";
		Method getMethod = clazz.getDeclaredMethod(getMethodName);
		System.out.println(getMethod.invoke(obj));
	}
}
