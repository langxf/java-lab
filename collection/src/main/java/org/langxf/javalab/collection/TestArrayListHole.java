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
    private static final String s6 = "字符串6";
    private static final String s7 = "字符串7";

    public static void main(String args[]) {
        TestArrayListHole test = new TestArrayListHole();
//        test.testSubListHole1();
//        test.testSubListHole2();
        test.testSubListHole3();
    }

    /**
     * Arrays.asList返回的是java.util.Arrays$ArrayList，不是java.util.ArrayList。
     * 二者都实现了java.util.AbstractList，但前者没有具体实现add方法，内部会抛出异常UnsupportedOperationException
     */
    public void testArraysAsList() {
        List<String> list = Arrays.asList(s1, s2);
        list.add(s3);

        list.forEach((ele -> {
            System.out.println("--------->>" + ele);
        }));
    }

    /**
     * java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
     */
    public void testSubListHole1() {
        List<String> rawList = prepareList();

        // java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
        List<String> subList = (ArrayList)rawList.subList(0, 3);
        subList.forEach((ele -> {
            System.out.println("----------->>>" + ele);
        }));
    }

    /**
     * 对subList进行的操作会影响原list，因为对subList的操作，实际都是在操作原list
     * 源码中在构建java.util.ArrayList$SubList时，实际使用的是原list对象
     */
    public void testSubListHole2() {
        List<String> rawList = prepareList();

        List<String> subList = rawList.subList(0, 3);
        printList(subList, "subList----before subList modify---->>>");
        printList(rawList, "rawList----before subList modify---->>>");

        subList.add(s6);
        subList.remove(0);
        printList(subList, "subList----after subList modify---->>>");
        printList(rawList, "rawList----after subList modify---->>>");
    }

    /**
     * 获得到java.util.ArrayList$SubList对象之后，不能再对原ArrayList对象进程修改操作，否则subList不可用(抛出ConcurrentModificationException)
     */
    public void testSubListHole3() {
        List<String> rawList = prepareList();
        List<String> subList = rawList.subList(0, 3);
        printList(rawList, "rawList----before rawList modify---->>>");
        printList(subList, "subList----before rawList modify---->>>");

        rawList.add(s6);
        printList(rawList, "rawList----after rawList modify---->>>");
//        printList(subList, "subList----after rawList modify---->>>");
        // Exception in thread "main" java.util.ConcurrentModificationException
        // at java.util.ArrayList$SubList.checkForComodification(ArrayList.java:1231)

        subList.get(0);
        subList.remove(0);
        subList.add(s7);

        printList(rawList, "rawList----after rawList modify2---->>>");
        printList(subList, "subList----before rawList modify2---->>>");
    }

    public List<String> prepareList() {
        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        return list;
    }

    private void printList(List<String> list, String msg) {
        for (String ele : list) {
            System.out.println(msg + ele);
        }
    }
}