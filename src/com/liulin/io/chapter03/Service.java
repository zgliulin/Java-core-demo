package com.liulin.io.chapter03;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class Service {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            // 从网络上拿到一个数据输入流
            InputStream inputStream = socket.getInputStream();

            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = inputStream.read(buff)) != -1){
                System.out.println(new String(buff,0,len,"UTF-8"));
            }
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
