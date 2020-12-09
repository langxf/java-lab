package org.langxf.javalab.base.annotation.inject.info;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Langxf on 2020/6/12.
 */
public class InfoInjectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        /** 通过反射获得方法sing */
        Class<Singer> singerClz = Singer.class;
        Method singMethod = singerClz.getDeclaredMethod("sing", String.class, int.class);

        /** 获取方法对应的注解 */
        Person personAnno = singMethod.getAnnotation(Person.class);
        String name = personAnno.name();
        int age = personAnno.age();

        /** 将注解信息注入到sing方法内部 */
        Singer singer = singerClz.newInstance();
        singMethod.invoke(singer, name, age);
        

    }
}
