package com.miaolegemitong.basics.jvm.monitoring;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/31
 * @description
 */
public class JConsoleThreadDeadLock {
    /**
     * 线程死锁等待演示
     * */
    static class SynAddRunnable implements Runnable {
        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}
