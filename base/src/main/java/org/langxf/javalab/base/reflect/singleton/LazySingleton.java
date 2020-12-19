package org.langxf.javalab.base.reflect.singleton;

/**
 * @author Langxf
 * @date 2020/12/19
 * 懒汉式单例
 */
public class LazySingleton {
	public static LazySingleton getInstance() {
		if (null == instance) {
			synchronized (LazySingleton.class) {
				if (null == instance) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}

	private LazySingleton() {
		System.out.println(Thread.currentThread().getName() + "： 实例化了懒汉式单例对象");
	}
	private static volatile LazySingleton instance = null;
}
