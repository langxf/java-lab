package org.langxf.javalab.base.reflect.classinfo;

import java.io.Serializable;

/**
 * @author Langxf
 * @date 2020/12/19
 * 演示通过反射获取到类对应的结构信息，比如：
 * 1. 包路径
 * 2. 父类
 * 3. 接口数组
 * 4. 无惨构造函数
 */
public class Message extends AbstractMessage implements IService, Serializable {
	private String content;
	private int type;

	@Override
	public boolean connect() {
		return true;
	}

	public Message() {}

	public Message(String content, int type) {
		this.content = content;
		this.type = type;
	}

	public void send() {
		send(this.content);
	}

	@Override
	public void send(String content) {
		if (connect()) {
			System.out.println("连接成功，发送消息：【" + content + "】，消息类型为：【" + type + "】");
		} else {
			System.out.println("消息发送失败，请检查网络！");
		}
	}

	@Override
	public String toString() {
		return "我是一个消息呀，咿呀咿呀呦！！！";
	}
}
