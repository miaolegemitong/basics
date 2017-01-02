package com.miaolegemitong.basics.jvm.gc.memoryallocation;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/30
 * @description VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class BigObjDirectIntoOldGen {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
