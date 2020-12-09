package org.langxf.javalab.base.annotation.inject.info;

import org.langxf.javalab.common.util.StringUtils;

/**
 * Created by Langxf on 2020/6/12.
 */
public class Singer {

    @Person(name = "李宗盛", age = 59)
    public void sing(String name, int age) {
        StringUtils.println("name：" + name);
        StringUtils.println("age：" + age);
    }
}
