package org.langxf.javalab.base.reflect.singleton;

/**
 * @author Langxf
 * @date 2020/12/19
 * 饿汉式单例
 */
public class HungrySingleton {

	public static HungrySingleton getInstance() {
		return instance;
	}

	private HungrySingleton() {
		System.out.println(Thread.currentThread().getName() + "： 实例化了饿汉式单例对象。");
	}
	private static volatile HungrySingleton instance = new HungrySingleton();
}
