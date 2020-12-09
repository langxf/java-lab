package org.langxf.javalab.base.annotation.repeatable;

import java.lang.annotation.Documented;

/**
 * Created by Langxf on 2020/6/11.
 */
@Documented
public @interface Persons {
    Person[] value();
}
