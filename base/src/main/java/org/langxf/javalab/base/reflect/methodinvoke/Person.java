package org.langxf.javalab.base.reflect.methodinvoke;

import java.util.Date;

/**
 * @author Langxf
 * @date 2020/12/19
 * 反射调用getter/setter
 */
public class Person {
	private long id;
	private String name;
	private int age;
	private Date birthday;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void print() {
		System.out.println("身份证号：" + id + "，姓名：" + name + "，年龄：" + age + "，生日：" + birthday);
	}
}
