package com.miaolegemitong.basics.java.thread.state;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class NewState {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println(t.getState());
    }
}
