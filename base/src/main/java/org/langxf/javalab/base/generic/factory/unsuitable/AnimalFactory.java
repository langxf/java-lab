package org.langxf.javalab.base.generic.factory.unsuitable;

/**
 * @author Langxf
 * @date 2020/12/11
 * 传统的工厂类：动物类工厂，只负责生产动物，如果有n种产品，switch需要做n次case，效率低下
 */
public class AnimalFactory {
    public static void main(String[] args) {
        IAnimal pig = AnimalFactory.create(Pig.class);
        pig.sleep();

        IAnimal horse = AnimalFactory.create(Horse.class);
        horse.sleep();
    }

    public static IAnimal create(Class<? extends IAnimal> clazz) {
        if (null == clazz)
            throw new NullPointerException();

        IAnimal animal = null;
        try {
            animal = (IAnimal) clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return animal;
    }
}

interface IAnimal {
    void sleep();
}

class Pig implements IAnimal {
    @Override
    public void sleep() {
        System.out.println("猪是躺着睡的！");
    }
}

class Horse implements IAnimal {
    @Override
    public void sleep() {
        System.out.println("马是站着睡的！");
    }
}
