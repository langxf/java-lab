package org.langxf.javalab.base.codeblock;

/**
 * @author Langxf
 * @date 2020/12/10
 */
public class StaticBlock {

    public StaticBlock() {
        System.out.println("3--->构造函数被调用！");
    }

    {
        System.out.println("2--->构造块优先于构造函数被调用，和代码顺序无关！");
    }

    static {
        System.out.println("1--->静态代码块类初始化时执行，只执行1次，优先于构造函数，用户初始化一些静态变量");
    }

    public static void main(String[] args) {
        new StaticBlock();
        new StaticBlock();
        new StaticBlock();
    }
}
