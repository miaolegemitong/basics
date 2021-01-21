package com.miaolegemitong.basics.java.thread.state;

/**
 * @author mitong
 * @date 2018/4/30
 * @email mitong@meituan.com
 * @desc
 */
public class JoinWaitingState {
    static class JoinWaiting implements Runnable {
        private Thread thread;

        public JoinWaiting(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Join waiting thread is running!");
            while (true) {
            }
        }
    }

    static class Joined implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread joinedThread = new Thread(new Joined());
        joinedThread.start();
        Thread joinThread = new Thread(new JoinWaiting(joinedThread));
        joinThread.start();
        Thread.sleep(10);
        System.out.println(joinThread.getState());
        Thread.sleep(1000);
        System.out.println(joinThread.getState());
    }
}
