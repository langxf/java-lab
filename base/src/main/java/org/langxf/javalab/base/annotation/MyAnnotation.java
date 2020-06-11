package org.langxf.javalab.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Native;

/**
 * Created by Langxf on 2020/6/9.
 */
@Documented
public @interface MyAnnotation {
    String name() default "defaultName";
    String password() default "defaultPassword";
}
