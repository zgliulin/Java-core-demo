package com.liulin.io.chapter02;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class BufferedDemo {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("G:/test.txt"));
             // 默认是8kb
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("G:/test-2.txt"))) {
            int len = 0;
            byte[] bys = new byte[1024];
            while ((len = inputStream.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
                outputStream.write(bys, 0, len);
                outputStream.flush();
            }
        } catch (Exception e) {

        }
    }

}
