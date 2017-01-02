package com.miaolegemitong.basics.jvm.gc.memoryallocation;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/28
 * @description VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails +XX:SurvivorRatio=8
 */
public class EdenFirst {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
    }
}
