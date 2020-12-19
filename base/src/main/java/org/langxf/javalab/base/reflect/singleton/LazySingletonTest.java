package org.langxf.javalab.base.reflect.singleton;

/**
 * @author Langxf
 * @date 2020/12/19
 */
public class LazySingletonTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(LazySingleton.getInstance());
			}).start();
		}
	}
}
