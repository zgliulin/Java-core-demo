package com.liulin.io.chapter02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class ReadDemo {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("G:/test.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("G:/test1.txt")) {
            int i = 0;
            byte[] buffer = new byte[3];
            while ((i = fileInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer,0,i));
            }
        } catch (Exception e) {

        }
    }
}
