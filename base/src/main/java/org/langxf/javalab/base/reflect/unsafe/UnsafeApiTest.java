package org.langxf.javalab.base.reflect.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class UnsafeApiTest {
	public static void main(String[] args) throws InstantiationException, NoSuchFieldException, IllegalAccessException {
		// 通过反射机制，根据属性名称获取Unsafe类的theUnsafe属性对象
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		// 解除私有属性封装
		field.setAccessible(true);
		// 获取Unsafe实例
		Unsafe unsafe = (Unsafe)field.get(null);
		// 通过UnSafe对象绕过JVM，创建只有私有构造函数的类的实例
		Singleton singleton = (Singleton)unsafe.allocateInstance(Singleton.class);
		singleton.print();
	}
}
