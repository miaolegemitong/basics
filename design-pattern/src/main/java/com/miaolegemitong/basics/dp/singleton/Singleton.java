package com.miaolegemitong.basics.dp.singleton;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/26
 * @description
 */
public class Singleton {
    private static final Singleton SINGLETON = new Singleton();

    // 限制产生多个对象
    private Singleton() {
    }

    // 通过该方法获得对象实例
    public static Singleton getSingleton() {
        return SINGLETON;
    }

    // 类中其他方法，尽量是static
    public static void doSomething() {
    }
}
