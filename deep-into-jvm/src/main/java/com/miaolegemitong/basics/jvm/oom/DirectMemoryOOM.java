package com.miaolegemitong.basics.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/22
 * @description VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
