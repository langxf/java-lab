package org.langxf.javalab.base.annotation.inject.info;

import java.lang.annotation.*;

/**
 * Created by Langxf on 2020/6/12.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Person {
    String name() default "unknown";
    int age() default 30;
}
