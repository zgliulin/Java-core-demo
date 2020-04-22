package com.liulin.io.chapter02;

import java.io.FileInputStream;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class ByteReadDemo {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("G:/test.txt")){
            int len = 0;
            while ((len = inputStream.read()) != -1) {
                System.out.print((char)len);
            }
        }catch (Exception e){

        }
    }
}
