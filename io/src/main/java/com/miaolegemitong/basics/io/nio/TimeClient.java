package com.miaolegemitong.basics.io.nio;

/**
 * @author mitong
 * @date 2019-03-19
 * @email mitong@meituan.com
 * @desc
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException ignored) {
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "Timeclient-001").start();
    }
}
