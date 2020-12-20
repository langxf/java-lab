package org.langxf.javalab.base.reflect.field;

import org.langxf.javalab.base.reflect.methodinvoke.Person;

/**
 * @author Langxf
 * @date 2020/12/20
 * 通过反射给多种类型属性赋值，演示类为 org.langxf.javalab.base.reflect.methodinvoke.Person
 * 赋值字符串格式：属性:value|属性:value，e.g id:130725198601010015|name:mapleleave|age:34|birthday:1986-01-01
 */
public class SetMultiKindFieldsValueTest {
	public static void main(String[] args) throws ClassNotFoundException {
		String classPath = "org.langxf.javalab.base.reflect.methodinvoke.Person";
		String values = "id:130725198601010015|name:mapleleave|age:34|birthday:1986-01-01";
		Person person = ClassInstanceFactory.create(classPath, values);

		person.print();
	}
}


