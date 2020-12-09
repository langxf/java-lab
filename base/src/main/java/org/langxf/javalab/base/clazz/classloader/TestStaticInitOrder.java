package org.langxf.javalab.base.clazz.classloader;

import java.util.concurrent.TimeUnit;

public class TestStaticInitOrder {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Son.WORD);

    }
}

class Father {
    public static final String WORD = "Father";
    static {
        System.out.println("class Father static structure invoked!");
    }
    private void method(int a) {

    }
}

class Son extends Father {
    static {
        System.out.println("class Son static structure invoked!");
    }
    public void method(int a) {

    }
}

