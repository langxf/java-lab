package org.langxf.javalab.base.reflect.instantiation;

/**
 * @author Langxf
 * @date 2020/12/18
 */
public class Person {

	public Person() {
		System.out.println("构造方法被调用");
	}

	@Override
	public String toString() {
		return this.getClass() + " 这是调用通过反射实例化Person对象的toString()方法！";
	}
}
