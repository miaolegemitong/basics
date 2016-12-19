package com.miaolegemitong.basics.jvm.oom;

/**
 * @author miaolegemitong
 * @email mitong1993@gmail.com
 * @date 2016/12/17
 * @description VM Args: -Xss256k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
