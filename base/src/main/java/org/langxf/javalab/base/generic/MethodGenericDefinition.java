package org.langxf.javalab.base.generic;

/**
 * @author Langxf
 * @date 2020/12/11
 * 泛型方法
 */
public class MethodGenericDefinition {
    public static void main(String[] args) {
        Integer[] intArr = fun(1,2,3);
        for (int data : intArr) {
            System.out.print(data + ",");
        }

        System.out.println();

        String[] strArr = fun("hello", "mapleleave,", "this", "is", "generic", "method.");
        for (String data : strArr) {
            System.out.print(data + " ");
        }
    }

    /**
     * 泛型方法
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T[] fun(T ... args) {
        return args;
    }
}
