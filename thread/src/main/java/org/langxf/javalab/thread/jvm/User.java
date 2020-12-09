package org.langxf.javalab.thread.jvm;

/**
 * @author Langxf
 *
 * javac 编译以后，检查class文件结构
 */
public class User {
    public static int work() {
        int a = 2;
        int b = 3;
        int c = a * b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(work());
    }
}
