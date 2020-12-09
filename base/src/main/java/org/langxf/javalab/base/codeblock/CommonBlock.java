package org.langxf.javalab.base.codeblock;

/**
 * @author Langxf
 * @date 2020/12/10
 */
public class CommonBlock {
    public static void main(String[] args) {
        {
            int blockVar = 0;
            System.out.println("------>>普通代码块1中的局部变量：" + blockVar);
        }

        int blockVar = 0;
        System.out.println("------->>main函数代码块中的变量：" + blockVar);
    }
}
