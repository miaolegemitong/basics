package com.miaolegemitong.basics.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaolegemitong
 * @email mitong1993@gmail.com
 * @date 2016/12/17
 * @description VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
