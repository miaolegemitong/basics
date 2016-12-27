package com.miaolegemitong.basics.dp.singleton;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/26
 * @description 线程不安全的单例
 */
public class ThreadUnsafeSingleton {
    private static ThreadUnsafeSingleton singleton = null;

    private ThreadUnsafeSingleton() {
    }

    public static ThreadUnsafeSingleton getSingleton() {
        if (singleton == null) {
            singleton = new ThreadUnsafeSingleton();
        }
        return singleton;
    }
}
