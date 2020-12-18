package org.langxf.javalab.base.reflect.instantiation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Langxf
 * @date 2020/12/18
 * 实例化代码演示，从JDK9开始，clazz.newInstance()被废弃不推荐使用，
 * 由 clazz.getDeclaredConstructor().newInstance() 所代替
 */
public class InstantiationDemo {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = Person.class;

		// JDK1.9之后被废弃不推荐
		Person person1 = (Person) clazz.newInstance();
		System.out.println(person1);

		// JDK1.9开始替代clazz.newInstance();
		Person person2 = (Person) clazz.getDeclaredConstructor().newInstance();
		System.out.println(person2);
	}
}
