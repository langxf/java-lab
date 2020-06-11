package org.langxf.javalab.base.annotation.inherited;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Langxf on 2020/6/11.
 */
@Documented
@Inherited
// 注解默认的保留时间为CLASS，这使得该注解无法进入RUNTIME时期，因此想注解修饰的类可以被子类继承，必须加上
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInheritedAnnotation {
}
