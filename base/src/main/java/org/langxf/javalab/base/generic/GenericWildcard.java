package org.langxf.javalab.base.generic;
import java.util.*;

/**
 * @author Langxf
 * @date 2020/12/10
 *
 * 使用泛型通配符，解决泛型类型参数，在进行方法参数传递的问题
 * 三种泛型通配符的“类型定义”和“方法传参”格式：
 * 1. 定义`Info<T>`，方法传参`Info<\?>`
 * 2. 定义`Info<T extends 类型X>`，方法传参`Info<\? extends 类型X>`(设置泛型上限：只能是子类型)
 * 3. 定义`Info<T>`，方法传参`Info<\? super 类型X>`（设置类型下限：只能是父类）
 */
public class GenericWildcard {

    public static void main(String[] args) {
        Info<String> strInfo = new Info<>();
        strInfo.setContent("String类型的Info");
        printInfo(strInfo);

        Info<Integer> intInfo = new Info<>();
        intInfo.setContent(100);
        printInfo(intInfo);
    }

    /**
     * 泛型通配符`<\?>`，方法中不可以再修改Info的类型
     * 泛型上限：`<\? extends 类型>`
     * 泛型下限：`<\? super 类型>`
     * @param info
     */
    public static void printInfo(Info<?> info) {
        // info.setContent("泛型只容许获取值，不容许修改值，反之类型被修改");
        System.out.println(info.getContent());
    }
}

class Info<T> {
    private T content;

    public T getContent() {
        return this.content;
    }
    public void setContent(T content) {
        this.content = content;
    }
}