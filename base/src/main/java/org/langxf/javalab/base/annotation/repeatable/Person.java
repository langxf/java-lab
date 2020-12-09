package org.langxf.javalab.base.annotation.repeatable;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;

/**
 * Created by Langxf on 2020/6/11.
 */
@Documented
@Repeatable(Persons.class)
public @interface Person {
    String role() default "";
}
