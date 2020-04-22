package com.liulin.io.chapter02;

import java.io.*;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class InputStreamDemo {
    // G:/apache-tomcat-8.5.30-windows-x64.zip
    public static void main(String[] args) throws IOException {
        File file = new File("G:/io.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream("G:/io-1.jpg");
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) != -1) {
            // 读取的数据可以保存在内存中
            //也可以写出到磁盘
            fileOutputStream.write(buffer,0,len); // 把InputStream的输入字节写出到指定的目录下
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
