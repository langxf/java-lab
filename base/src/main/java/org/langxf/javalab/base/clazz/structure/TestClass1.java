package org.langxf.javalab.base.clazz.structure;

import java.util.Map;

public class TestClass1 {

    private int m;

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        printRunYear();
    }

    public static void printRunYear() {
        for (int y = 2000; y <= 2500; y++) {
            if ((y % 4 == 0 && y % 100 != 0) || (y % 100 == 0 && y % 400 == 0)) {
                System.out.println(y + "是闰年！");
            }
        }
    }

    public static int mul() {
        int t = 1;
        for (int i = 2; i <= 5; i++) {
            t = t * i;
        }
        System.out.println(t);
        return t;
    }
}


interface Action {
    void action();

    default void method() {
        System.out.println("------>>");
    }
}