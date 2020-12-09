package org.langxf.javalab.base.annotation;

import java.lang.annotation.Native;

/**
 * Created by Langxf on 2020/6/9.
 */
@MyAnnotation(name = "langxf", password = "123qwe")
public class TestAnnotation {

    public void test() {

    }

    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        testAnnotation.test();
    }
}
