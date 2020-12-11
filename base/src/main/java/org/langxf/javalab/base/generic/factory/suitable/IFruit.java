package org.langxf.javalab.base.generic.factory.suitable;

/**
 * @author Langxf
 * @date 2020/12/11
 */
public interface IFruit {
    /**
     * 吃水果
     */
    void eat();
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("苹果可以直接吃！");
    }
}

class Banana implements IFruit {
    @Override
    public void eat() {
        System.out.println("香蕉需要剥皮吃！");
    }
}
