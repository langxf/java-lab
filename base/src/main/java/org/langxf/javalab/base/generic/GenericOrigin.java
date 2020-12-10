package org.langxf.javalab.base.generic;

/**
 * @author Langxf
 * @date 2020/12/10
 * 设计一个Point类，支持以下三种数据类型
 * . 整型  x = 10, y = 20
 * . 浮点型 x = 8.1, y = 18.8
 * . 字符串 x = 东经120度，北纬40度
 */
public class GenericOrigin {
    public static void main(String[] args) {
        rightDemo1();
        rightDemo2();
        rightDemo3();

        // 设置数据时没有限制类型，获取数据时报错
        wrongDemo();
    }

    public static void rightDemo1() {
        Point point = new Point();
        point.setX(10);
        point.setY(20);

        Integer x = (Integer) point.getX();
        Integer y = (Integer) point.getY();
        System.out.println("point: x=" + x + ", y=" + y);
    }

    public static void rightDemo2() {
        Point point = new Point();
        point.setX(8.1F);
        point.setY(18.8F);

        Float x = (Float) point.getX();
        Float y = (Float) point.getY();
        System.out.println("point: x=" + x + ", y=" + y);
    }

    public static void rightDemo3() {
        Point point = new Point();
        point.setX("东经120度");
        point.setY("北纬40度");

        String x = (String) point.getX();
        String y = (String) point.getY();
        System.out.println("point: x=" + x + ", y=" + y);
    }

    /**
     * 在rightDemo1的基础上，由于没有泛型限制，假如setY输入字符串，这样getY获取本认为应该获取到的是Integer，
     * 但真实值为String，这样编译器不会出错，但是在运行期会报出向下转型时错误(ClassCastException)。
     * 从JDK1.5之后出现的泛型，提前在编译器就报错，比解决RuntimeException要简单的多，就杜绝了这个问题。
     */
    public static void wrongDemo() {
        Point point = new Point();
        point.setX(10);
        point.setY("北纬40度");

        Integer x = (Integer) point.getX();
        Integer y = (Integer) point.getY();
        System.out.println("point: x=" + x + ", y=" + y);
    }
}

class Point {
    private Object x;
    private Object y;

    public Object getX() {
        return this.x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return this.y;
    }

    public void setY(Object y) {
        this.y = y;
    }
}
