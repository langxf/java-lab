package org.langxf.javalab.base.reflect.unsafe;

/**
 * @author Langxf
 * @date 2020/12/20
 */
public class Singleton {
	private Singleton() {
		System.out.println("测试Unsafe类实例化对象！");
	}
	public void print() {
		System.out.println("mapleleave");
	}
}
