package org.langxf.javalab.base.annotation.inherited;

/**
 * Created by Langxf on 2020/6/11.
 */
public class Son1 extends Father {
    public static void main(String args[]) {
        println(Son1.class.isAnnotation());
        println(MyInheritedAnnotation.class.isAnnotation());
        // MyInheritedAnnotation必须指定@Retention(RetentionPolicy.RUNTIME)，不然不会继承父类的注解
        println(Son1.class.isAnnotationPresent(MyInheritedAnnotation.class));
    }
}
