package com.liulin.io.chapter02;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class TestDemo {
    public static void main(String[] args) {
        // 磁盘IO
        /*try {
            FileInputStream inputStream = new FileInputStream("G:/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        // 内存IO
        /*String str = "Hello World !";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        int i = 0;
        while ((i = byteArrayInputStream.read()) != -1) {
            System.out.print((char)i);
        }*/

        // 键盘
        // Scanner
        /*InputStream inputStream = System.in;
        int i = 0;
        while ((i = inputStream.read()) != -1) {
            System.out.print((char)i);
        }*/

        // 网络IO
        /*Socket socket ;
        socket.getInputStream();
        socket.getOutputStream();*/
    }
}
