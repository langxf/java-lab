package org.langxf.javalab.base.annotation.reflect;

import java.lang.annotation.*;

/**
 * Created by Langxf on 2020/6/10.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ClassAnno {
    String value();
}