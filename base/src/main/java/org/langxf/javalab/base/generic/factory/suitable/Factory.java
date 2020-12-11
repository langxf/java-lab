package org.langxf.javalab.base.generic.factory.suitable;

/**
 * @author Langxf
 * @date 2020/12/11
 */
public class Factory<T> {

    public static void main(String[] args) {
        IFruit apple = Factory.create(Apple.class);
        IFruit banana = Factory.create(Banana.class);
        apple.eat();
        banana.eat();

        IAnimal pig = Factory.create(Pig.class);
        IAnimal horse = Factory.create(Horse.class);
        pig.sleep();
        horse.sleep();
    }

    /**
     * 定义泛型方法，接收T类型，并且返回T类型实例化对象，大幅减少Factory类
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz) {
        if (null == clazz)
            throw new NullPointerException();

        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return instance;
    }
}

