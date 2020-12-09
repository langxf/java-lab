package org.langxf.javalab.thread.threadlocal;

import java.util.concurrent.TimeUnit;

public class TestThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String name;

    public static void main(String[] args) {
        TestThreadLocal test = new TestThreadLocal();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                test.setName(Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程" + Thread.currentThread().getName() + " 拿到的数据：" + test.getName());
            });

            t.setName("Thread-" + i);
            t.start();
        }

        /*
         * 必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，
         * 如果不清理自定义的 ThreadLocal变量，可能会影响后续业务逻辑和造成内存泄露等问题。
         * 尽量在代理中使用try-finally块进行回收。
         */
        threadLocal.remove();
    }

    public String getName() {
        return threadLocal.get();
    }

    public void setName(String name) {
        threadLocal.set(name);
    }

}
