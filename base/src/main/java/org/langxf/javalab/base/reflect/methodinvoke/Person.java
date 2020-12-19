package org.langxf.javalab.base.reflect.methodinvoke;

/**
 * @author Langxf
 * @date 2020/12/19
 * 反射调用getter/setter
 */
public class Person {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
