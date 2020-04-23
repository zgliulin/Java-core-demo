package com.liulin.io.chapter03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        // 发送一个数据到客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello World".getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
