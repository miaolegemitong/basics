package com.miaolegemitong.basics.io.bio.pool;

import com.miaolegemitong.basics.io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mitong
 * @date 2019-03-18
 * @email mitong@meituan.com
 * @desc
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception ignored) {
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is started in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                pool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                server.close();
                server = null;
                System.out.println("The time server is closed");
            }
        }
    }

}
