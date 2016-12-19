package com.miaolegemitong.basics.jvm.oom;

/**
 * @author miaolegemitong
 * @email mitong1993@gmail.com
 * @date 2016/12/17
 * @description
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
//        String a = "java1";

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va1").toString();
        System.out.println(str2.intern() == str2);
    }
}
