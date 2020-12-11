package org.langxf.javalab.base.generic;

/**
 * @author Langxf
 * @date 2020/12/10
 * 基本泛型定义：(GenericOrigin)中暴露出来的问题，避免ClassCastException安全隐患。
 */
public class BasicGenericDefinition {

    public static void main(String[] args) {
        rightDemo();
    }

    public static void rightDemo() {
        Point<Integer> point = new Point<>();
        point.setX(10);
        point.setY(20);
        // GenericOrigin中错误范例point.setY("北纬40度")不能这么设置，编译直接报错

        // 使用泛型后，也不需要做类型强转，也就是Object类型这种用法过时了
        Integer x = point.getX();
        Integer y = point.getY();
        System.out.println("point: x=" + x + ", y=" + y);
    }

    /**
     * 之所以使用内部类，是因为和GenericOrigin中Point类型冲突
     */
    static class Point<T> {
        private T x;
        private T y;

        public T getX() {
            return this.x;
        }

        public void setX(T x) {
            this.x = x;
        }

        public T getY() {
            return this.y;
        }

        public void setY(T y) {
            this.y = y;
        }
    }
}

