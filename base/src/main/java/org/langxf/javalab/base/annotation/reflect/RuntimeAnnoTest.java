package org.langxf.javalab.base.annotation.reflect;

import org.langxf.javalab.common.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by Langxf on 2020/6/10.
 */
public class RuntimeAnnoTest {

    public static void outInfo() {
        StringBuilder buffer = new StringBuilder();
        Class<?> clazz = RuntimeAnnoEntity.class;

        /** 获取ClassAnno的注解信息 */
        outClassAnnoInfo(clazz, buffer);

        /** 获取MethodAnno的注解信息 */
        outMethodAnnoInfo(clazz, buffer);

        /** 获取FieldAnno的注解信息 */
        outFieldAnnoInfo(clazz, buffer);

        StringUtils.println(buffer);

    }

    public static void outClassAnnoInfo(Class<?> clazz, StringBuilder buffer) {
        ClassAnno classAnno = clazz.getAnnotation(ClassAnno.class);
        if (null != classAnno) {
            buffer.append("ClassAnno注解信息：").append("\n");
            buffer.append(Modifier.toString(clazz.getModifiers())).append(" ");
            buffer.append("注解值为：").append(classAnno.value()).append("\n\n");
        }
    }

    public static void outMethodAnnoInfo(Class<?> clazz, StringBuilder buffer) {
        Method methods[] = clazz.getDeclaredMethods();
        if (null != methods && methods.length > 0) {
            buffer.append("MethodAnno注解信息：").append("\n");
            for (Method method : methods) {
                if (null != method) {
                    MethodAnno methodAnno = method.getAnnotation(MethodAnno.class);
                    if (null != methodAnno) {
                        buffer.append(Modifier.toString(method.getModifiers())).append(" ")
                                .append(method.getReturnType().getSimpleName()).append(" ")
                                .append(method.getName()).append("\n");
                        buffer.append("注解值为：\n");
                        buffer.append("name--->").append(methodAnno.name()).append("\n");
                        buffer.append("data--->").append(methodAnno.data()).append("\n");
                        buffer.append("age---->").append(methodAnno.age()).append("\n\n");
                    }
                }
            }
        }
    }

    public static void outFieldAnnoInfo(Class<?> clazz, StringBuilder buffer) {
        Field fields[] = clazz.getDeclaredFields();
        if (null != fields) {
            for (Field field : fields) {
                if (null != field) {
                    FieldAnno fieldAnno = field.getAnnotation(FieldAnno.class);
                    if (null != fieldAnno) {
                        buffer.append("FieldAnno注解：\n");
                        buffer.append(Modifier.toString(field.getModifiers())).append(" ")
                                .append(field.getType().getSimpleName()).append(" ")
                                .append(field.getName()).append("\n");
                        buffer.append("注解值为：").append(Arrays.toString(fieldAnno.value())).append("\n\n");
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        StringUtils.println("------111--->>>");

        outInfo();
    }

}
