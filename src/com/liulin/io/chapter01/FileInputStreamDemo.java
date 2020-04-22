package com.liulin.io.chapter01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("G:/test.txt");
            int i = 0;
            while ((i = fileInputStream.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println((char)i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
