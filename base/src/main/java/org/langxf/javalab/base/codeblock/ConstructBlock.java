package org.langxf.javalab.base.codeblock;

/**
 * @author Langxf
 * @date 2020/12/10
 */
public class ConstructBlock {
    public ConstructBlock() {
        System.out.println("2---->构造方法每次new 对象都会被调用！");
    }
    {
        System.out.println("1---->构造代码块每次new也会被执行，并且先于构造函数(和代码先后顺序无关)，用于初始化一些变量！");
    }

    public static void main(String[] args) {
        new ConstructBlock();
        new ConstructBlock();
        new ConstructBlock();
    }
}