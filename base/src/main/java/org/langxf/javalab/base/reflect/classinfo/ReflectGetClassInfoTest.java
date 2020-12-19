package org.langxf.javalab.base.reflect.classinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Langxf
 * @date 2020/12/19
 */
public class ReflectGetClassInfoTest {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		Class<Message> clazz = Message.class;

		System.out.println("包路径：" + clazz.getPackage().getName());
		System.out.println("父类：" + clazz.getSuperclass().getName());

		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class itf : interfaces) {
			System.out.println("实现接口数组：" + itf.getName());
		}

		// 必须有一个无参构造函数，否则抛出NoSuchMethodException
		Constructor constructorNoArg = clazz.getDeclaredConstructor();
		System.out.println("无惨构造函数：" + constructorNoArg.getName());
		Message messageNoArg = (Message)constructorNoArg.newInstance();
		messageNoArg.send("无惨构造函数消息");

		// 反射调用有参构造函数
		Constructor constructorHasArg = clazz.getConstructor(String.class, int.class);
		Message messageHasArg = (Message)constructorHasArg.newInstance("有参构造函数消息", 200);
		messageHasArg.send();
	}
}
