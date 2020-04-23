package com.liulin.io.chapter03;

import javax.naming.ldap.SortKey;
import java.io.*;
import java.net.Socket;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class ClientSocketClass {

    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        try {
            Socket socket = new Socket("localhost", DEFAULT_PORT);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("客户端发送消息：client-01\n");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serviceStr = bufferedReader.readLine();
            System.out.println("收到服务端消息："+serviceStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
