package com.miaolegemitong.basics.java.thread.state;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class ConditionWaitingState {
    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    static class ConditonWaiting implements Runnable {
        public void run() {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread conditionThread = new Thread(new ConditonWaiting());
        conditionThread.start();
        Thread.sleep(100);
        System.out.println(conditionThread.getState());
        lock.lock();
        condition.signal();
        lock.unlock();
        Thread.sleep(1000);
        System.out.println(conditionThread.getState());
    }
}
