package org.langxf.javalab.base.annotation.reflect;

import java.lang.annotation.*;

/**
 * Created by Langxf on 2020/6/10.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodAnno {
    String name() default "method";
    String data();
    int age() default 34;
}
