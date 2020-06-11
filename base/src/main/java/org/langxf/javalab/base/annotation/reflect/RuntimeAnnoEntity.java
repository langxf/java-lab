package org.langxf.javalab.base.annotation.reflect;

/**
 * Created by Langxf on 2020/6/10.
 */
@ClassAnno("ClassAnno-RunTime")
public class RuntimeAnnoEntity {
    @FieldAnno(value = {66, 88})
    public String word = "hello";

    @FieldAnno(value = {1024})
    public int number = 2018;

    @MethodAnno(name = "sayHelloMethodAnno", data = "good", age = 30)
    public static void sayHello() {
        System.out.println("this is sayHello method!");
    }
}
