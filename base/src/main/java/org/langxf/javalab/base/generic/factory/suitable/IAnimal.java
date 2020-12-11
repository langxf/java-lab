package org.langxf.javalab.base.generic.factory.suitable;

/**
 * @author Langxf
 * @date 2020/12/11
 */
public interface IAnimal {
    /**
     * 使用动物睡觉行为进行测试
     */
    void sleep();
}

class Pig implements IAnimal {
    @Override
    public void sleep() {
        System.out.println("Pig吃饱了倒头就睡！");
    }
}

class Horse implements IAnimal {
    @Override
    public void sleep() {
        System.out.println("Horse是站着睡的！");
    }
}