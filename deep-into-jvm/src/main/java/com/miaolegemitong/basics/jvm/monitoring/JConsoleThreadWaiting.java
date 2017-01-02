package com.miaolegemitong.basics.jvm.monitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/31
 * @description
 */
public class JConsoleThreadWaiting {
    /**
     * 线程死循环演示
     * */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     * 线程锁等待演示
     * */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
