package org.langxf.javalab.base.generic;

/**
 * @author Langxf
 * @date 2020/12/11
 * 泛型接口定义示例，演示两种泛型接口实现：
 * 1. 子类依然使用泛型，示例(MessageImpl)
 * 2. 子类明确泛型类型，示例(MessageCodeImpl)
 *
 */
public class GenericInterfaceDefinition {
    public static void main(String[] args) {
        // 1. 子类依然使用泛型2个示例
        IMessage<String> msg = new MessageImpl<>();
        System.out.println(msg.echo("MessageImpl被调用了！"));
        IMessage<Double> doubleMsg = new MessageImpl<>();
        System.out.println(doubleMsg.echo(3.141592653579D));

        // 2. 子类使用明确泛型类型
        IMessage<Integer> intMsg = new MessageCodeImpl<>();
        System.out.println(intMsg.echo(2147483647));
    }
}

interface IMessage<T> {
    String echo(T msg);
}

/**
 * 子类依然使用泛型
 * @param <T>
 */
class MessageImpl<T> implements IMessage<T> {
    @Override
    public String echo(T msg) {
        return "ECHO: " + msg;
    }
}

/**
 * 子类明确泛型类型
 * @param <Integer>
 */
class MessageCodeImpl<Integer> implements IMessage<Integer> {
    @Override
    public String echo(Integer msgCode) {
        return "Msg Code is:" + msgCode;
    }
}
