package com.miaolegemitong.basics.java.thread.state;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class RunnableState {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                }
            }
        });
        t.start();
        System.out.println(t.getState());
    }
}
