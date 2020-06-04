package org.langxf.javalab.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayListHole {

    private static final String s1 = "字符串1";
    private static final String s2 = "字符串2";
    private static final String s3 = "字符串3";
    private static final String s4 = "字符串4";
    private static final String s5 = "字符串5";

    public static void main(String args[]) {
        TestArrayListHole test = new TestArrayListHole();
        test.testSubList();
    }

    public void testArraysAsList() {
        List<String> list = Arrays.asList(s1, s2);
        list.add(s3);

        list.forEach((ele -> {
            System.out.println("--------->>" + ele);
        }));
    }

    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        List<String> subList = list.subList(0, 3);
        subList.forEach((ele -> {
            System.out.println("----------->>>" + ele);
        }));
    }

}