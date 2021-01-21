package com.miaolegemitong.basics.java.thread.state;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class LockWaitingState {
    private static Lock lock = new ReentrantLock();

    static class LockWaiting implements Runnable {
        public void run() {
            lock.lock();
            System.out.println("Lock waiting thread is running!");
            while (true) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        lock.lock();
        Thread lockThread = new Thread(new LockWaiting());
        lockThread.start();
        Thread.sleep(100);
        System.out.println(lockThread.getState());
        lock.unlock();
        Thread.sleep(100);
        System.out.println(lockThread.getState());
    }
}
