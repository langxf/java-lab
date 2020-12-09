package org.langxf.javalab.base.clazz.structure;

public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

    public int inc1() {
        int x;
        try {
            x = 1;
            x = x / 0;
            return x;
        } catch (Exception e) {
            x = 2;
            System.out.println("catch:" + x);
            return x;
        } finally {
            x = 3;
            System.out.println("catch:" + x);
        }
    }
}
