package org.langxf.javalab.base.generic.factory.unsuitable;

/**
 * @author Langxf
 * @date 2020/12/11
 * 传统的工厂类：水果类工厂，只负责生产水果，如果有n种产品，switch需要做n次case，效率低下
 */
public class FruitFactory {

    public static void main(String[] args) {
        IFruit apple = FruitFactory.create(IFruit.TYPE.APPLE);
        apple.eat();

        IFruit banana = FruitFactory.create(IFruit.TYPE.BANANA);
        banana.eat();
    }

    public static IFruit create(IFruit.TYPE type) {
        switch (type) {
            case APPLE : return new Apple();
            case BANANA : return new Banana();
            default : return null;
        }
    }

    private FruitFactory() {}
}

interface IFruit {
    enum TYPE {
        APPLE, BANANA
    }

    void eat();
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("Apple可以直接吃");
    }
}

class Banana implements IFruit {
    @Override
    public void eat() {
        System.out.println("Banana需要剥皮吃");
    }
}
