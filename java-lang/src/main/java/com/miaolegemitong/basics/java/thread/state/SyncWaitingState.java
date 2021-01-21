package com.miaolegemitong.basics.java.thread.state;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class SyncWaitingState {
    private static Object obj = new Object();

    static class SyncWaiting implements Runnable {
        public void run() {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Sync waiting thread is running!");
            while (true) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread syncThread = new Thread(new SyncWaiting());
        syncThread.start();
        Thread.sleep(100);
        System.out.println(syncThread.getState());
        synchronized (obj) {
            obj.notify();
        }
        Thread.sleep(50);
        System.out.println(syncThread.getState());
    }
}
